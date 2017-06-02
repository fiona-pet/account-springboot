package cn.fiona.pet.facade;

import cn.fiona.pet.dto.ListFilter;
import cn.fiona.pet.dto.PageSearch;
import cn.fiona.pet.dto.SearchFilter;
import cn.fiona.pet.dto.Sort;
import cn.fiona.pet.entity.UserRole;

import com.alibaba.fastjson.JSON;

import org.junit.Test;

/**
 * 用户和角色关系信息
 * Created by tom on 2017-06-02 10:37:08.
 */
public class UserRoleRestServiceTest {

  private SmartHttpClient client = new SmartHttpClient();

  @Test
  public void create() throws Exception {
      String token = client.buildToken("admin", "admin");
      UserRole entity = new UserRole();

      client.post("/userroles", token, JSON.toJSONString(entity));
  }

  @Test
  public void detail() throws Exception {
      String token = client.buildToken("admin", "admin");
      client.get("/userroles/27f962a0bbc7c0bc129fdcf6559cfae6", token);
  }

  @Test
  public void list() throws Exception {
      String token = client.buildToken("admin", "admin");
      client.get("/userroles/list", token);
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
      client.post("/userroles/page", token, JSON.toJSONString(pageSearch));
  }


  @Test
  public void delete() throws Exception {
      String token = client.buildToken("admin", "admin");
      client.delete("/userroles/2c913f795b9f1039015b9f15cf2e0000", token);
  }
}
