package cn.fiona.pet.service;

import cn.fiona.pet.entity.UserRole;
import cn.fiona.pet.repository.UserRoleDao;

import lombok.Getter;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

/**
 *  用户和角色关系信息
 * Created by tom on 2017-06-02 10:37:08.
 */
@Getter
public class UserRoleServiceImpl extends CURDServiceBase<UserRole> implements UserRoleService {
    @Autowired
    private UserRoleDao dao;
}