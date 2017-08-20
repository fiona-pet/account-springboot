package cn.fiona.pet.facade;

import cn.fiona.pet.converter.Converter;
import cn.fiona.pet.dto.RoleMenuDTO;
import cn.fiona.pet.dto.UserRoleDTO;
import cn.fiona.pet.entity.RoleMenu;
import cn.fiona.pet.entity.UserRole;
import io.swagger.annotations.ApiOperation;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.List;

/**
 * 角色和菜单关系信息 接口
 *
* Created by tom on 2017-06-02 09:47:59.
 */
public interface RoleMenuRestService extends CURDRestService<RoleMenuDTO>,Converter<RoleMenuDTO, RoleMenu>{
    @POST
    @Path("/batch")
    @ApiOperation("添加/修改")
    void createBatch(List<RoleMenuDTO> roleMenuDTOs);
}
