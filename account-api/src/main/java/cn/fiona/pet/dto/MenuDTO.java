package cn.fiona.pet.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * 用户信息
 *
 * <p>
 * Created by tom on 2017-05-19 14:31:34.
 */
@ApiModel("用户信息")
@ToString
@Setter
@Getter
public class MenuDTO{
    @ApiModelProperty(value = "id")
    private String id;

    
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