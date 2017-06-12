package cn.fiona.pet.service;

import cn.fiona.pet.dto.MenuDTO;
import cn.fiona.pet.entity.Menu;

import java.util.List;
import java.util.Set;

/**
 * 菜单信息
 * Created by tom on 2017-05-19 14:33:47.
 */
public interface MenuService extends CURDService<Menu> {

    /**
     * 根菜单编码
     */
    public static final String MENU_ROOT = "M00000";

    /**
     * 获取根据token获取菜单数据
     *
     * @param token
     * @return
     */
    Set<Menu> findByToken(String token);

    /**
     * 根据父级code获取菜单数据
     *
     * @param code
     * @return
     */
    List<Menu> findByParentMenuCode(String code);

    /**
     * 根据token获取菜单数据
     *
     * @param token
     * @return
     */
    List<MenuDTO> menus(String token);
}
