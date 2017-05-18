package cn.fiona.pet.service;

import cn.fiona.pet.dto.SearchFilter;
import cn.fiona.pet.entity.User;
import cn.fiona.pet.repository.UserDao;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

import lombok.Getter;

import javax.validation.constraints.NotNull;

/**
 * 用户信息
 * Created by tom on 2017-03-07 13:25:01.
 */


@Service
@Getter
public class UserServiceImpl extends CURDServiceBase<User> implements UserService {

    @Autowired
    private UserDao dao;

    @Override
    public User getUserByLoginName(@NotBlank @NotNull String loginName) {
        return dao.findByLoginName(loginName);
    }
}
