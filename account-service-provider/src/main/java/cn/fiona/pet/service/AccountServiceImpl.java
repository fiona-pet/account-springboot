package cn.fiona.pet.service;

import cn.fiona.pet.dto.SignInDTO;
import cn.fiona.pet.entity.Organize;
import cn.fiona.pet.entity.Role;
import cn.fiona.pet.entity.User;
import cn.fiona.pet.repository.RoleDao;
import cn.fiona.pet.repository.UserDao;
import com.alibaba.dubbo.common.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springside.modules.security.utils.Digests;
import org.springside.modules.utils.Encodes;

import javax.validation.constraints.NotNull;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by tom on 2017/6/2.
 */
public class AccountServiceImpl implements AccountService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    private Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Override
    public String login(@NotNull SignInDTO signInDTO) {
        User user = userDao.findByLoginName(signInDTO.getName());

        if (null == user) {
            throw new RuntimeException(String.format("[%s]用户未找到!", signInDTO));
        }

        String password = signInDTO.getPassword();

        if (StringUtils.isBlank(password)) {
            throw new InvalidParameterException("密码不能为空!");
        }

        if (!passwordValidation(password, user)) {
            throw new InvalidParameterException("密码错误!");
        }

        String token = user.getId();

        return token;
    }

    private boolean passwordValidation(String password, User user) {

        byte[] salt = Encodes.decodeHex(user.getSalt());

        byte[] hashPassword = Digests.sha1(password.getBytes(), salt, 1024);

        return user.getPassword().equals(Encodes.encodeHex(hashPassword));
    }

    @Override
    public boolean validateToken(@NotNull String token) {
        if (StringUtils.isBlank(token)){
            throw new InvalidParameterException("token is null!");
        }

        User user = userDao.findOne(token);
        if (null == user){
            throw new InvalidParameterException(String.format("%s not exists!", token));
        }

        return true;
    }

    @Override
    public User getByToken(String token) {
        User user = userDao.findOne(token);

        if (null == user) {
            throw new InvalidParameterException(String.format("%s not exists!", token));
        }

        User userVO = new User();
        userVO.setId(user.getId());
        userVO.setName(user.getName());
        userVO.setLoginName(user.getLoginName());

        return userVO;
    }

    @Override
    public List<User> listByRoleCode(String code) {
        Role role = roleDao.findByCode(code);
        List<User> users = new ArrayList<User>();
        for (User user: role.getUsers()){
            User userVO = new User();
            userVO.setName(user.getName());
            userVO.setId(user.getId());
            userVO.setLoginName(user.getLoginName());
            users.add(userVO);
        }

        return users;
    }

    @Override
    public User createUser(User user) {
        Organize organize =  new Organize();
        organize.setId("9b06d376-44ff-4153-9b31-c29a19b8da29");
        user.setOrganize(organize);

        Set<Role> roleSet = new HashSet<Role>();

        for (Role role: user.getRoles()){
            logger.debug("add role:{}", role.getCode());
            Role r = roleDao.findByCode(role.getCode());
            roleSet.add(r);
        }

        if (roleSet.size() == 0){
            roleSet.add(roleDao.findByCode("doctor"));
        }

        user.setRoles(roleSet);

        encode(user);

        userDao.save(user);

        User userVO = new User();

        userVO.setId(user.getId());
        userVO.setName(user.getName());
        userVO.setLoginName(user.getLoginName());

        return userVO;
    }

    private void encode(User user){

        byte[] salt = Encodes.decodeHex(user.getSalt());

        byte[] hashPassword = Digests.sha1(user.getPlainPassword().getBytes(), salt, 1024);

        user.setPassword(Encodes.encodeHex(hashPassword));
    }

    @Override
    public boolean hasRole(String role, String token) {
        User user = userDao.findOne(token);

        if (null == user) {
            throw new InvalidParameterException(String.format("%s not exists!", token));
        }

        for (Role r: user.getRoles()){
            if (r.getCode().equalsIgnoreCase(role)){
                return true;
            }
        }

        return false;
    }
}
