package cn.fiona.pet.facade;

import cn.fiona.pet.converter.Converter;
import cn.fiona.pet.dto.MenuDTO;
import cn.fiona.pet.entity.Menu;

/**
 * 菜单信息 接口
 *
* Created by tom on 2017-05-19 14:32:57.
 */
public interface MenuRestService extends CURDRestService<MenuDTO>,Converter<MenuDTO, Menu>{

}
