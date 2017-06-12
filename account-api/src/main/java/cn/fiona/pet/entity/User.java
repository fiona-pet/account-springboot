package cn.fiona.pet.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 用户信息
 * <p>
 * Created by tom on 2017-03-07 15:29:42.
 */
@Entity
@Table(name = "t_user")
@DynamicInsert
@DynamicUpdate
@Setter
@Getter
@ToString
public class User extends IdEntity {
    /**
     * 登录名
     */
    @ApiModelProperty(value = "登录名", required = true)
    private String loginName;
    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名", required = true)
    private String name;
    /**
     * 明文密码
     */
    private String plainPassword;
    /**
     * 加密密码
     */
    @ApiModelProperty(value = "加密密码", required = true)
    private String password;
    /**
     * 加密 佐料
     */
    private String salt;

    /**
     * 注册日期
     */
    @ApiModelProperty(value = "注册日期")
    private Date registerDate;
    // 设定JSON序列化时的日期格式
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    public Date getRegisterDate() {
        return registerDate;
    }

    /**
     * 所属企业
     */
    private Organize organize;

    // 不持久化到数据库，也不显示在Restful接口的属性.
    @Transient
    @JsonIgnore
    public String getPlainPassword() {
        return plainPassword;
    }
//
//    /**
//     * 用户 角色 信息
//     */
//    private Set<Role> roles = new HashSet<Role>();
//
//    @ManyToMany(fetch= FetchType.EAGER)
//    @JoinTable(name="t_user_role",
//            joinColumns={@JoinColumn(name="user_id")},
//            inverseJoinColumns={@JoinColumn(name="role_id")}
//    )
//    public Set<Role> getRoles() {
//        return roles;
//    }

    @ManyToOne
    @JoinColumn(name = "enterprise_id", referencedColumnName = "id")
    public Organize getOrganize() {
        return organize;
    }

}
