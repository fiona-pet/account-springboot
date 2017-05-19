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
     * 
     */
    @ApiModelProperty(value = "", required = false)
    private String parentId;
    
}