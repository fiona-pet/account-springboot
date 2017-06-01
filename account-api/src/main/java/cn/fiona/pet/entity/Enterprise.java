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
 * 企业信息
 * <p>
* Created by tom on 2017-06-01 10:57:18.
 */
@ApiModel("企业信息")
@Entity
@Table(name = "t_enterprise")
@DynamicInsert
@DynamicUpdate
@Setter
@Getter
@ToString
public class Enterprise extends IdEntity {
    
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