/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package cn.fiona.pet.repository;

import cn.fiona.pet.entity.User;

public interface UserDao extends DaoBase<User> {
    User findByLoginName(String loginName);
}
