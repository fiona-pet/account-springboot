package cn.fiona.pet.facade;

import cn.fiona.pet.entity.Menu;
import cn.fiona.pet.entity.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.fiona.pet.dto.RoleMenuDTO;
import cn.fiona.pet.entity.RoleMenu;
import cn.fiona.pet.service.RoleMenuService;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import io.swagger.annotations.Api;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 角色和菜单关系信息
 * Created by tom on 2017-06-02 09:47:59.
 */
@Api(value="rolemenus", description = "角色和菜单关系信息接口")
@Service(protocol = "rest")
@Path("rolemenus")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({ContentType.APPLICATION_JSON_UTF_8})
@Getter
public class RoleMenuRestServiceImpl extends ConverterRestServiceBase<RoleMenuDTO, RoleMenu> implements RoleMenuRestService {
    private static final Logger LOGGER = LoggerFactory.getLogger(RoleMenuRestServiceImpl.class);

    @Autowired
    private RoleMenuService service;

    @Override
    public void backwardAfter(RoleMenuDTO dto, RoleMenu roleMenu) {
        super.backwardAfter(dto, roleMenu);

        Role role = new Role();
        role.setCode(dto.getRoleCode());

        roleMenu.setRole(role);

        Menu menu = new Menu();
        menu.setCode(dto.getMenuCode());

        roleMenu.setMenu(menu);

    }

    @Override
    public void forwardAfter(RoleMenuDTO dto, RoleMenu roleMenu) {
        super.forwardAfter(dto, roleMenu);
        dto.setMenuCode(roleMenu.getMenu().getCode());
        dto.setRoleCode(roleMenu.getRole().getCode());
    }

    @Override
    public Map<String, String> toEntityKey() {
        Map<String, String> toEntityKey = new HashMap<String, String>();

        toEntityKey.put("roleCode", "role.code");
        toEntityKey.put("menuCode", "menu.code");

        return toEntityKey;
    }

    @Override
    public void createBatch(List<RoleMenuDTO> roleMenuDTOs) {
        for (RoleMenuDTO roleMenuDTO: roleMenuDTOs){
            RoleMenu roleMenu = new RoleMenu();

            this.backwardAfter(roleMenuDTO, roleMenu);

            service.createOrUpdte(roleMenu);
        }
    }
}
