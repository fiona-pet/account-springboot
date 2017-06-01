package cn.fiona.pet.facade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.fiona.pet.dto.OrganizeDTO;
import cn.fiona.pet.entity.Organize;
import cn.fiona.pet.service.OrganizeService;
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
 * 组织信息
 * Created by tom on 2017-06-01 11:13:25.
 */
@Api(value="organizes", description = "组织信息接口")
@Path("organizes")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({ContentType.APPLICATION_JSON_UTF_8})
@Getter
public class OrganizeRestServiceImpl extends ConverterRestServiceBase<OrganizeDTO, Organize> implements OrganizeRestService {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrganizeRestServiceImpl.class);

    @Autowired
    private OrganizeService service;
}
