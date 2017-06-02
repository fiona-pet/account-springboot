package cn.fiona.pet.facade;

import cn.fiona.pet.converter.Converter;
import cn.fiona.pet.dto.RoleMenuDTO;
import cn.fiona.pet.entity.RoleMenu;

/**
 * 角色和菜单关系信息 接口
 *
* Created by tom on 2017-06-02 09:47:59.
 */
public interface RoleMenuRestService extends CURDRestService<RoleMenuDTO>,Converter<RoleMenuDTO, RoleMenu>{

}
