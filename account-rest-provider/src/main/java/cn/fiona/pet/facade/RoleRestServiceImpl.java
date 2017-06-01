package cn.fiona.pet.facade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.fiona.pet.dto.RoleDTO;
import cn.fiona.pet.entity.Role;
import cn.fiona.pet.service.RoleService;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import io.swagger.annotations.Api;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * 角色信息
 * Created by tom on 2017-06-01 11:28:43.
 */
@Api(value="roles", description = "角色信息接口")
@Path("roles")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({ContentType.APPLICATION_JSON_UTF_8})
@Getter
public class RoleRestServiceImpl extends ConverterRestServiceBase<RoleDTO, Role> implements RoleRestService {
    private static final Logger LOGGER = LoggerFactory.getLogger(RoleRestServiceImpl.class);

    @Autowired
    private RoleService service;
}
