package cn.fiona.pet.converter;

import cn.fiona.pet.dto.UserDTO;
import cn.fiona.pet.entity.User;

import com.google.common.collect.Lists;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mq
 * Date: 2017/5/12
 * Time: 11:42
 * To change this template use File | Settings | File Templates.
 */
@Component
public class UserDataConverter implements DataConverter<UserDTO, User> {

    // @Autowired
    // BusinessService businessService;

    @Override
    public UserDTO doForward(User user) {
        // Business business = businessService.detail(user.getBusinessId());
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user, userDTO);
        // userDTO.setBusinessName(business.getDisplayName());
        return userDTO;
    }

    @Override
    public User doBackward(UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        return user;
    }

    @Override
    public List<UserDTO> doForwardList(List<User> list) {
        List<UserDTO> result = Lists.newArrayList();
        for (User user : list) {
            result.add(this.doForward(user));
        }
        return result;
    }

    @Override
    public List<User> doBackwardList(List<UserDTO> list) {
        List<User> result = Lists.newArrayList();
        for (UserDTO userDTO : list) {
            result.add(this.doBackward(userDTO));
        }
        return result;
    }
}
