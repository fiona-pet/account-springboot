package cn.fiona.pet.service;


import cn.fiona.pet.dto.SignInDTO;
import cn.fiona.pet.entity.User;

import java.util.List;

/**
 * 账号接口
 *
 * @author baiqw
 */
public interface AccountService {
    /**
     * 用户登录
     *
     * @param signInDTO
     * @return 登录成功返回 token
     */
    String login(SignInDTO signInDTO);

    /**
     * token 验证
     *
     * @param token
     * @return
     */
    boolean validateToken(String token);

    /**
     * 根据 token 获取用户信息
     *
     * @param token
     * @return
     */
    User getByToken(String token);

    /**
     * 根据 角色 code 获取用户列表
     *
     * @param code
     * @return
     */
    List<User> listByRoleCode(String code);

    User createUser(User user);

    boolean hasRole(String role, String token);
}