package cn.fiona.pet.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * 角色和菜单关系信息
 *
 * <p>
 * Created by tom on 2017-06-02 09:47:59.
 */
@ApiModel("角色和菜单关系信息")
@ToString
@Setter
@Getter
public class RoleMenuDTO{
    @ApiModelProperty(value = "id")
    private String id;

    
    /**
     * 
     */
    @ApiModelProperty(value = "", required = false)
     private String roleCode;
    
    /**
     * 
     */
    @ApiModelProperty(value = "", required = false)
     private String menuCode;
    
}