package cn.fiona.pet.facade;

import cn.fiona.pet.converter.Converter;
import cn.fiona.pet.dto.OrganizeDTO;
import cn.fiona.pet.entity.Organize;

/**
 * 组织信息 接口
 *
* Created by tom on 2017-06-01 11:13:25.
 */
public interface OrganizeRestService extends CURDRestService<OrganizeDTO>,Converter<OrganizeDTO, Organize>{

}
