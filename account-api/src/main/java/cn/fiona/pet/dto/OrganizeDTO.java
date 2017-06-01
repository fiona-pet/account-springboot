package cn.fiona.pet.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * 组织信息
 *
 * <p>
 * Created by tom on 2017-06-01 11:13:25.
 */
@ApiModel("组织信息")
@ToString
@Setter
@Getter
public class OrganizeDTO{
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
    
}