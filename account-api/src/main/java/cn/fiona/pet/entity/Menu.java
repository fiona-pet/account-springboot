package cn.fiona.pet.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 菜单信息
 * <p>
* Created by tom on 2017-05-19 14:29:17.
 */
@ApiModel("菜单信息")
@Entity
@Table(name = "t_menu")
@DynamicInsert
@DynamicUpdate
@Setter
@Getter
@ToString
public class Menu extends IdEntity {
    
    /**
     * 
     */
    @ApiModelProperty(value = "", required = false)
    private String name;
    
    /**
     * 
     */
    @ApiModelProperty(value = "", required = false)
    private String code;
    
    /**
     * 
     */
    @ApiModelProperty(value = "", required = false)
    private String uri;
    
    /**
     * 
     */
    @ApiModelProperty(value = "", required = false)
    private String iconClass;
    
    /**
     * 
     */
    @ApiModelProperty(value = "", required = false)
    private String describe;
    
    /**
     * 
     */
    @ApiModelProperty(value = "", required = false)
    private Boolean leaf;
    
    /**
     * 
     */
    @ApiModelProperty(value = "", required = false)
    private Integer order;
    
    /**
     * 角色菜单 信息
     */
    private Set<RoleMenu> roleMenus;
    @OneToMany(fetch= FetchType.EAGER, mappedBy = "menu")
    public Set<RoleMenu> getRoleMenus() {
        return roleMenus;
    }

    /**
     * 子组
     */
    private Set<Menu> menus = new LinkedHashSet<Menu>();
    /**
     * 父组
     */
    private Menu parentMenu;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY, mappedBy = "parentMenu")
    public Set<Menu> getMenus() {
        return menus;
    }


    @JsonIgnore
    @ManyToOne(cascade = CascadeType.DETACH,fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id", referencedColumnName = "code")
    @NotFound(action = NotFoundAction.IGNORE)
    public Menu getParentMenu() {
        return parentMenu;
    }

}