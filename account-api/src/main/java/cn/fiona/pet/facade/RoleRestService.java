package cn.fiona.pet.facade;

import cn.fiona.pet.converter.Converter;
import cn.fiona.pet.dto.RoleDTO;
import cn.fiona.pet.entity.Role;

/**
 * 角色信息 接口
 *
* Created by tom on 2017-06-01 11:28:43.
 */
public interface RoleRestService extends CURDRestService<RoleDTO>,Converter<RoleDTO, Role>{

}
