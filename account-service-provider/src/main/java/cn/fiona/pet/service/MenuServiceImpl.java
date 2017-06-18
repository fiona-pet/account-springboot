package cn.fiona.pet.service;

import cn.fiona.pet.dto.MenuDTO;
import cn.fiona.pet.entity.Menu;
import cn.fiona.pet.entity.RoleMenu;
import cn.fiona.pet.entity.User;
import cn.fiona.pet.entity.UserRole;
import cn.fiona.pet.repository.MenuDao;

import cn.fiona.pet.repository.UserDao;
import lombok.Getter;
import org.apache.commons.collections.CollectionUtils;
import org.hibernate.validator.constraints.NotBlank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.*;

/**
 *  菜单信息
 * Created by tom on 2017-05-19 14:36:41.
 */
@Service
@Getter
public class MenuServiceImpl extends CURDServiceBase<Menu> implements MenuService {
    @Autowired
    private MenuDao dao;

    private static final Logger LOGGER = LoggerFactory.getLogger(MenuServiceImpl.class);

    @Autowired
    private MenuDao menuDao;

    @Autowired
    private UserDao userDao;

    @Override
    public Set<Menu> findByToken(String token) {
        Set<Menu> menus = new HashSet<Menu>();

        User user = userDao.findById(token);
        Set<UserRole> userRoles = user.getUserRoles();

        for (UserRole userRole : userRoles) {
            for (RoleMenu roleMenu: userRole.getRole().getRoleMenus()) {
                menus.add(roleMenu.getMenu());
            }
        }

        return menus;
    }

    @Override
    public List<Menu> findByParentMenuCode(String code) {
        return menuDao.findByParentMenuCodeOrderByOrderAsc(code);
    }

    @Override
    public List<MenuDTO> menus(String token) {
        LOGGER.debug("token:{}", token);
        Set<Menu> menuSet = findByToken(token);

        List<Menu> menuList = new ArrayList<Menu>();
        menuList.addAll(menuSet);
        Collections.sort(menuList, new Comparator<Menu>() {
            @Override
            public int compare(Menu o1, Menu o2) {
                return o1.getOrder() - o1.getOrder();
            }
        });

        menuList.addAll(findByParentMenuCode(MENU_ROOT));

        List<MenuDTO> menus = new ArrayList<MenuDTO>();

        findChild(menuList, menus, new HashSet<Menu>(), MENU_ROOT);

        menus = orderAndRemoveNoSub(menus);

        LOGGER.debug("menus:{}", menus);

        return menus;
    }

    private List<MenuDTO> orderAndRemoveNoSub(List<MenuDTO> menus) {
        List<MenuDTO> list = new ArrayList<MenuDTO>();

        LOGGER.debug("order list:{}", list);

        for (MenuDTO MenuDTO : menus) {
            if (CollectionUtils.isEmpty(MenuDTO.getSubMenu())) {
                continue;
            }

            list.add(MenuDTO);

            Collections.sort(MenuDTO.getSubMenu(), new Comparator<MenuDTO>() {
                @Override
                public int compare(MenuDTO o1, MenuDTO o2) {
                    return o1.getOrder()-o2.getOrder();
                }
            });
        }

        menus.clear();

        return list;
    }

    private void findChild(List<Menu> menuSet, List<MenuDTO> MenuDTOList, Set<Menu> hasFind, String code) {
        for (Menu menu : menuSet) {

            if (hasFind.contains(menu)) {
                continue;
            }

            Menu parentMenu = menu.getParentMenu();

            if (parentMenu == null || code.equals(parentMenu.getCode())) {
                MenuDTO menuDTO = new MenuDTO(menu);

                menuDTO.setParentId(menu.getParentMenu().getId());
                menuDTO.setParentCode(menu.getParentMenu().getCode());

                MenuDTOList.add(menuDTO);

                hasFind.add(menu);
            }
        }

        for (MenuDTO MenuDTO : MenuDTOList) {
            findChild(menuSet, MenuDTO.getSubMenu(), hasFind, MenuDTO.getCode());
        }
    }
}