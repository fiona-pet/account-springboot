package cn.fiona.pet.service;

import cn.fiona.pet.entity.Enterprise;
import cn.fiona.pet.repository.EnterpriseDao;

import lombok.Getter;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

/**
 *  企业信息
 * Created by tom on 2017-06-01 10:57:18.
 */
@Service
@Getter
public class EnterpriseServiceImpl extends CURDServiceBase<Enterprise> implements EnterpriseService {
    @Autowired
    private EnterpriseDao dao;
}