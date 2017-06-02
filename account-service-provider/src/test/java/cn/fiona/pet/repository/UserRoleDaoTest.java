package cn.fiona.pet.repository;

import cn.fiona.pet.TestSmartApplication;
import cn.fiona.pet.entity.UserRole;
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
* 用户和角色关系信息
* Created by tom on 2017-06-02 10:37:08.
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TestSmartApplication.class)
@ComponentScan("cn.fiona.pet.")
@EnableAutoConfiguration
public class UserRoleDaoTest {

    @Autowired
    private UserRoleDao dao;

    @Test
    public void findAll() {
        List<UserRole> lists = dao.findAllBy();

        Assert.assertNotNull(lists);

        Assert.assertEquals(lists.size(), 0);
    }
}
