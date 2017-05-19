package cn.fiona.pet.facade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.fiona.pet.dto.MenuDTO;
import cn.fiona.pet.entity.Menu;
import cn.fiona.pet.service.MenuService;
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
 * 菜单信息
 * Created by tom on 2017-05-19 14:35:59.
 */
@Api(value="menus", description = "菜单信息接口")
@Path("menus")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({ContentType.APPLICATION_JSON_UTF_8})
@Getter
public class MenuRestServiceImpl extends ConverterRestServiceBase<MenuDTO, Menu> implements MenuRestService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MenuRestServiceImpl.class);

    @Autowired
    private MenuService service;
}
