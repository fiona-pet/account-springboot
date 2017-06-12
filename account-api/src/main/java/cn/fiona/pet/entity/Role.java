package cn.fiona.pet.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 角色信息
 * <p>
* Created by tom on 2017-06-01 11:28:43.
 */
@ApiModel("角色信息")
@Entity
@Table(name = "t_role")
@DynamicInsert
@DynamicUpdate
@Setter
@Getter
@ToString
public class Role extends IdEntity {
    
    /**
     * 名称
     */
    @ApiModelProperty(value = "", required = false)
    private String name;
    
    /**
     * 编码
     */
    @ApiModelProperty(value = "", required = false)
    private String code;
    
    /**
     * 描述
     */
    @ApiModelProperty(value = "", required = false)
    private String describe;

    /**
     * 用户 角色 信息
     */
    private Set<UserRole> userRoles = new HashSet<UserRole>();

    @OneToMany(fetch= FetchType.EAGER, mappedBy = "role")
    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    /**
     * 菜单 信息
     */
    private Set<RoleMenu> roleMenus;
    @OneToMany(fetch= FetchType.EAGER, mappedBy = "role")
//    @JoinColumn(name="code")
    public Set<RoleMenu> getRoleMenus() {
        return roleMenus;
    }
}