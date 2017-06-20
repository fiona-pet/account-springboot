package cn.fiona.pet.facade;

import cn.fiona.pet.dto.*;
import cn.fiona.pet.entity.Menu;

import com.alibaba.fastjson.JSON;

import org.junit.Test;

/**
 * 菜单信息
 * Created by tom on 2017-05-19 14:45:24.
 */
public class MenuRestServiceTest {

  private SmartHttpClient client = new SmartHttpClient();

  @Test
  public void create() throws Exception {
      String token = client.buildToken("admin", "admin");

      MenuDTO entity = new MenuDTO();
      entity.setCode("M00000");
      entity.setName("业务办理");
      entity.setUri("#");
      entity.setIconClass("nav-item");
      entity.setDescribe("业务办理");


      client.post("/menus", token, JSON.toJSONString(entity));
  }

  @Test
  public void detail() throws Exception {
      String token = client.buildToken("admin", "admin");
      client.get("/menus/27f962a0bbc7c0bc129fdcf6559cfae6", token);
  }

  @Test
  public void list() throws Exception {
      String token = client.buildToken("admin", "admin");
      client.get("/menus/list", token);
  }

  @Test
  public void page() throws Exception {
      String token = client.buildToken("admin", "admin");
      PageSearch pageSearch = new PageSearch();
      pageSearch.setPageSize(10);
      pageSearch.setPageNumber(1);

      pageSearch.addFilters(new SearchFilter("parentCode", SearchFilter.Operator.EQ, "M00350"));

      Sort sort = new Sort();
      sort.setFieldName("code");
      sort.setDirection("desc");
      pageSearch.setSort(sort);
      client.post("/menus/page", token, JSON.toJSONString(pageSearch));
  }


  @Test
  public void delete() throws Exception {
      String token = client.buildToken("admin", "admin");
      client.delete("/menus/2c913f795b9f1039015b9f15cf2e0000", token);
  }
}
