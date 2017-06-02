package cn.fiona.pet.facade;

import cn.fiona.pet.converter.Converter;
import cn.fiona.pet.dto.UserRoleDTO;
import cn.fiona.pet.entity.UserRole;

/**
 * 用户和角色关系信息 接口
 *
* Created by tom on 2017-06-02 10:37:08.
 */
public interface UserRoleRestService extends CURDRestService<UserRoleDTO>,Converter<UserRoleDTO, UserRole>{

}
