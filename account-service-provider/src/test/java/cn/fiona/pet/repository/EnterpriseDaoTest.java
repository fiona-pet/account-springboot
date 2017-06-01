package cn.fiona.pet.repository;

import cn.fiona.pet.TestSmartApplication;
import cn.fiona.pet.entity.Enterprise;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
* 企业信息
* Created by tom on 2017-06-01 10:57:18.
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TestSmartApplication.class)
@ComponentScan("cn.fiona.pet.")
@EnableAutoConfiguration
public class EnterpriseDaoTest {

    @Autowired
    private EnterpriseDao dao;

    @Test
    public void findAll() {
        List<Enterprise> lists = dao.findAllBy();

        Assert.assertNotNull(lists);

        Assert.assertEquals(lists.size(), 1);
    }
}
