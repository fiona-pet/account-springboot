package cn.fiona.pet.service;

import cn.fiona.pet.entity.Organize;
import cn.fiona.pet.repository.OrganizeDao;

import lombok.Getter;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

/**
 *  组织信息
 * Created by tom on 2017-06-01 11:13:25.
 */
@Getter
public class OrganizeServiceImpl extends CURDServiceBase<Organize> implements OrganizeService {
    @Autowired
    private OrganizeDao dao;
}