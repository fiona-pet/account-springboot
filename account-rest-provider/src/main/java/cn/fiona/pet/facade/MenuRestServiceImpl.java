package cn.fiona.pet.facade;

import cn.fiona.pet.dto.PageSearch;
import cn.fiona.pet.dto.RestResult;
import cn.fiona.pet.dto.SearchFilter;
import io.swagger.annotations.ApiOperation;
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
import org.springframework.data.domain.Page;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * 菜单信息
 * Created by tom on 2017-05-19 14:35:59.
 */
@Api(value="menus", description = "菜单信息接口")
@Path("menus")
@Service(protocol = "rest")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({ContentType.APPLICATION_JSON_UTF_8})
@Getter
public class MenuRestServiceImpl extends ConverterRestServiceBase<MenuDTO, Menu> implements MenuRestService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MenuRestServiceImpl.class);

    @Autowired
    private MenuService service;

    @Override
    @GET
    @Path("/")
    @ApiOperation(value = "用户菜单",
            notes = "用户菜单数据"
    )
    public RestResult<List<MenuDTO>> menus(@HeaderParam(AuthRestService.HEADER_AUTHORIZATION_KEY) String token) {
        List<MenuDTO> menus = service.menus(token);
        LOGGER.info("menus:{}", menus);
        return RestResult.OK(menus);
    }

    @Override
    public void forwardAfter(MenuDTO a, Menu menu) {
        if (menu.getParentMenu() != null ) {
            a.setParentId(menu.getParentMenu().getId());
            a.setParentCode(menu.getParentMenu().getCode());
        }
    }

    @Override
    public void backwardAfter(MenuDTO menuDTO, Menu menu) {
        Menu parentMenu = new Menu();
        parentMenu.setCode(menuDTO.getParentCode());
        parentMenu.setId(menuDTO.getParentId());
        menu.setParentMenu(parentMenu);
    }

    @Override
    public RestResult<Page<MenuDTO>> page(PageSearch pageSearch) {

        for (SearchFilter searchFilter: pageSearch.getFilters()){
            if ("parentCode".equals(searchFilter.getFieldName())){
                searchFilter.setFieldName("parentMenu.code");
            }
        }

        return super.page(pageSearch);
    }
}
