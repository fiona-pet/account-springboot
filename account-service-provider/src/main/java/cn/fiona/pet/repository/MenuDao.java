package cn.fiona.pet.repository;

import cn.fiona.pet.entity.Menu;

import java.util.List;

/**
 * 菜单信息
* Created by tom on 2017-05-19 14:36:00.
 **/
public interface MenuDao extends DaoBase<Menu> {
    List<Menu> findByParentMenuCodeOrderByOrderAsc(String code);
}
