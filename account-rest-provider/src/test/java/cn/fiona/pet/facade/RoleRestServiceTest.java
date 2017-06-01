package cn.fiona.pet.facade;

import cn.fiona.pet.dto.ListFilter;
import cn.fiona.pet.dto.PageSearch;
import cn.fiona.pet.dto.SearchFilter;
import cn.fiona.pet.dto.Sort;
import cn.fiona.pet.entity.Role;

import com.alibaba.fastjson.JSON;

import org.junit.Test;

/**
 * 角色信息
 * Created by tom on 2017-06-01 11:28:43.
 */
public class RoleRestServiceTest {

  private SmartHttpClient client = new SmartHttpClient();

  @Test
  public void create() throws Exception {
      String token = client.buildToken("admin", "admin");
      Role entity = new Role();

      client.post("/roles", token, JSON.toJSONString(entity));
  }

  @Test
  public void detail() throws Exception {
      String token = client.buildToken("admin", "admin");
      client.get("/roles/27f962a0bbc7c0bc129fdcf6559cfae6", token);
  }

  @Test
  public void list() throws Exception {
      String token = client.buildToken("admin", "admin");
      client.get("/roles/list", token);
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
      client.post("/roles/page", token, JSON.toJSONString(pageSearch));
  }


  @Test
  public void delete() throws Exception {
      String token = client.buildToken("admin", "admin");
      client.delete("/roles/2c913f795b9f1039015b9f15cf2e0000", token);
  }
}
