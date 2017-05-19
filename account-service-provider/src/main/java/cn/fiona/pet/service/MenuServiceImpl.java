package cn.fiona.pet.service;

import cn.fiona.pet.entity.Menu;
import cn.fiona.pet.repository.MenuDao;

import lombok.Getter;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

/**
 *  菜单信息
 * Created by tom on 2017-05-19 14:36:41.
 */
@Getter
public class MenuServiceImpl extends CURDServiceBase<Menu> implements MenuService {
    @Autowired
    private MenuDao dao;
}