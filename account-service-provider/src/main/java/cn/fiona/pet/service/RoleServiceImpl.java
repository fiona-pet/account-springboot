package cn.fiona.pet.service;

import cn.fiona.pet.entity.Role;
import cn.fiona.pet.repository.RoleDao;

import lombok.Getter;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

/**
 *  角色信息
 * Created by tom on 2017-06-01 11:28:43.
 */
@Getter
public class RoleServiceImpl extends CURDServiceBase<Role> implements RoleService {
    @Autowired
    private RoleDao dao;
}