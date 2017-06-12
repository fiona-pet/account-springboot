package cn.fiona.pet.facade;

import cn.fiona.pet.converter.Converter;
import cn.fiona.pet.dto.MenuDTO;
import cn.fiona.pet.dto.RestResult;
import cn.fiona.pet.entity.Menu;
import io.swagger.annotations.ApiOperation;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import java.util.List;

/**
 * 菜单信息 接口
 *
* Created by tom on 2017-05-19 14:32:57.
 */
public interface MenuRestService extends CURDRestService<MenuDTO>,Converter<MenuDTO, Menu>{
    /**
     * 菜单接口
     *
     * @param token
     * @return
     */
    RestResult<List<MenuDTO>> menus(@HeaderParam(AuthRestService.HEADER_AUTHORIZATION_KEY) String token);


}
