package cn.fiona.pet.facade;

import cn.fiona.pet.converter.Converter;
import cn.fiona.pet.dto.EnterpriseDTO;
import cn.fiona.pet.entity.Enterprise;

/**
 * 企业信息 接口
 *
* Created by tom on 2017-06-01 10:57:18.
 */
public interface EnterpriseRestService extends CURDRestService<EnterpriseDTO>,Converter<EnterpriseDTO, Enterprise>{

}
