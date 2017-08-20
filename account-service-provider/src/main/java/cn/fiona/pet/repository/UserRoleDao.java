package cn.fiona.pet.repository;

import cn.fiona.pet.entity.UserRole;

import java.util.List;

/**
 * 用户和角色关系信息
* Created by tom on 2017-06-02 10:37:08.
 **/
public interface UserRoleDao extends DaoBase<UserRole> {
    List<UserRole> findByRoleCode(String code);

    UserRole findByUserIdAndRoleId(String userId, String roleId);
}
