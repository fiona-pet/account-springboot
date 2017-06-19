package cn.fiona.pet.facade;

import cn.fiona.pet.dto.*;
import cn.fiona.pet.entity.User;

import com.google.common.collect.ImmutableList;

import com.alibaba.fastjson.JSON;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: mq
 * Date: 2017/4/24
 * Time: 14:40
 * To change this template use File | Settings | File Templates.
 */
public class UserRestServiceTest {

  private SmartHttpClient client = new SmartHttpClient();

  @Test
  public void create() throws Exception {
      String token = client.buildToken("admin", "admin");
      UserDTO user = new UserDTO();
      user.setName("ceshi23");
      user.setLoginName("测试");
      user.setPassword("123456");
      client.post("/users", token, JSON.toJSONString(user));
  }

  @Test
  public void detail() throws Exception {
      String token = client.buildToken("admin", "admin");
      client.get("/users/27f962a0bbc7c0bc129fdcf6559cfae6", token);
  }

  @Test
  public void list() throws Exception {
      String token = client.buildToken("admin", "admin");
      client.get("/users/list", token);
  }

  @Test
  public void page() throws Exception {
      String token = client.buildToken("admin", "admin");
      PageSearch pageSearch = new PageSearch();
      pageSearch.setPageSize(10);
      pageSearch.setPageNumber(1);
      Sort sort = new Sort();
      sort.setFieldName("displayName");
      sort.setDirection("desc");
      pageSearch.setSort(sort);
      client.post("/users/page", token, JSON.toJSONString(pageSearch));
  }


  @Test
  public void delete() throws Exception {
      String token = client.buildToken("admin", "admin");
      client.delete("/users/2c913f795b9f1039015b9f15cf2e0000", token);
  }
}
