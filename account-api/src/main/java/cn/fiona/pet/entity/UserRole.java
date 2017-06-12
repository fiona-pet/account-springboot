package cn.fiona.pet.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

/**
 * 用户和角色关系信息
 * <p>
* Created by tom on 2017-06-02 10:37:08.
 */
@ApiModel("用户和角色关系信息")
@Entity
@Table(name = "t_user_role")
@DynamicInsert
@DynamicUpdate
@Setter
@Getter
@ToString
public class UserRole extends IdEntity {
    /**
     * 用户信息
     */
    @ApiModelProperty(value = "用户信息", required = false)
    private User user;

    /**
     * 角色信息
     */
    @ApiModelProperty(value = "角色信息", required = false)
    private Role role;


    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH }, optional = true)
    @JoinColumn(name="user_id")
    public User getUser(){
        return user;
    }

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH }, optional = true)
    @JoinColumn(name="role_id")
    public Role getRole(){
        return this.role;
    }
    
}