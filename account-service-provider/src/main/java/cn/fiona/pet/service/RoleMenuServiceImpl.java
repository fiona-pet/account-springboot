package cn.fiona.pet.service;

import cn.fiona.pet.entity.RoleMenu;
import cn.fiona.pet.repository.RoleMenuDao;

import lombok.Getter;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

/**
 *  角色和菜单关系信息
 * Created by tom on 2017-06-02 09:47:59.
 */
@Service
@Getter
public class RoleMenuServiceImpl extends CURDServiceBase<RoleMenu> implements RoleMenuService {
    @Autowired
    private RoleMenuDao dao;
}