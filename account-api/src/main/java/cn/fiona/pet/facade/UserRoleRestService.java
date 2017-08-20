package cn.fiona.pet.facade;

import cn.fiona.pet.converter.Converter;
import cn.fiona.pet.dto.RestResult;
import cn.fiona.pet.dto.UserRoleDTO;
import cn.fiona.pet.entity.UserRole;
import io.swagger.annotations.ApiOperation;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.List;

/**
 * 用户和角色关系信息 接口
 *
* Created by tom on 2017-06-02 10:37:08.
 */
public interface UserRoleRestService extends CURDRestService<UserRoleDTO>,Converter<UserRoleDTO, UserRole>{

    @POST
    @Path("/batch")
    @ApiOperation("添加/修改")
    void createBatch(List<UserRoleDTO> userRoles);
}