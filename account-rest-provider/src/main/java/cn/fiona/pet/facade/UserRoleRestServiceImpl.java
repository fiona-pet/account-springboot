package cn.fiona.pet.facade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.fiona.pet.dto.UserRoleDTO;
import cn.fiona.pet.entity.UserRole;
import cn.fiona.pet.service.UserRoleService;
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
 * 用户和角色关系信息
 * Created by tom on 2017-06-02 10:37:09.
 */
@Api(value="userroles", description = "用户和角色关系信息接口")
@Service(protocol = "rest")
@Path("userroles")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({ContentType.APPLICATION_JSON_UTF_8})
@Getter
public class UserRoleRestServiceImpl extends ConverterRestServiceBase<UserRoleDTO, UserRole> implements UserRoleRestService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserRoleRestServiceImpl.class);

    @Autowired
    private UserRoleService service;
}
