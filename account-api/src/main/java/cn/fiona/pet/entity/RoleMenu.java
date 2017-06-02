package cn.fiona.pet.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * 角色和菜单关系信息
 * <p>
* Created by tom on 2017-06-02 09:47:59.
 */
@ApiModel("角色和菜单关系信息")
@Entity
@Table(name = "t_role_menu")
@DynamicInsert
@DynamicUpdate
@Setter
@Getter
@ToString
public class RoleMenu extends IdEntity {
    
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