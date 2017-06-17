package cn.fiona.pet.facade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.fiona.pet.dto.EnterpriseDTO;
import cn.fiona.pet.entity.Enterprise;
import cn.fiona.pet.service.EnterpriseService;
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
 * 企业信息
 * Created by tom on 2017-06-01 10:57:18.
 */
@Api(value="enterprises", description = "企业信息接口")
@Service(protocol = "rest")
@Path("enterprises")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({ContentType.APPLICATION_JSON_UTF_8})
@Getter
public class EnterpriseRestServiceImpl extends ConverterRestServiceBase<EnterpriseDTO, Enterprise> implements EnterpriseRestService {
    private static final Logger LOGGER = LoggerFactory.getLogger(EnterpriseRestServiceImpl.class);

    @Autowired
    private EnterpriseService service;
}
