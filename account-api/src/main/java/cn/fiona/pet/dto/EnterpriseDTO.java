package cn.fiona.pet.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * 企业信息
 *
 * <p>
 * Created by tom on 2017-06-01 10:57:18.
 */
@ApiModel("企业信息")
@ToString
@Setter
@Getter
public class EnterpriseDTO{
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