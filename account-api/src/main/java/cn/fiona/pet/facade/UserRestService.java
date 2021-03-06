package cn.fiona.pet.facade;

import cn.fiona.pet.converter.Converter;
import cn.fiona.pet.dto.UserDTO;
import cn.fiona.pet.entity.User;

/**
 * 用户信息 接口
 * <p>
 * Created by tom on 2017-03-07 13:25:01.
 */
 public interface UserRestService extends CURDRestService<UserDTO>,Converter<UserDTO, User> {

 }
