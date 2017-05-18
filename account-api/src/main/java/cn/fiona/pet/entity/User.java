package cn.fiona.pet.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 用户信息
 * <p>
 * Created by tom on 2017-03-07 15:29:42.
 */
@Entity
@Table(name = "t_user")
@DynamicInsert
@DynamicUpdate
@ApiModel("用户信息")
@Setter
@Getter
@ToString
public class User extends IdEntity {

    /**
     * 名称
     */
    @ApiModelProperty(value = "名称", required = false)
    @Column(name = "c_name", columnDefinition = "名称")
    private String name;

    /**
     * 账号
     */
    @ApiModelProperty(value = "账号", required = false)
    @Column(name = "c_account", columnDefinition = "账号")
    private String account;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码", required = false)
    @Column(name = "c_password", columnDefinition = "密码")
    private String password;

    /**
     * 性别
     */
    @ApiModelProperty(value = "性别", required = false)
    @Column(name = "c_sex", columnDefinition = "性别")
    private String sex;

    /**
     * 头像
     */
    @ApiModelProperty(value = "头像", required = false)
    @Column(name = "c_icon", columnDefinition = "头像")
    private String icon;

    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱", required = false)
    @Column(name = "c_email", columnDefinition = "邮箱")
    private String email;

    /**
     * 电话
     */
    @ApiModelProperty(value = "电话", required = false)
    @Column(name = "c_phone", columnDefinition = "电话")
    private String phone;

    /**
     * 是否自定义
     */
    @ApiModelProperty(value = "是否自定义", required = false)
    @Column(name = "c_is_custom", columnDefinition = "是否自定义")
    private Boolean isCustom;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注", required = false)
    @Column(name = "c_memo", columnDefinition = "备注")
    private String memo;

    /**
     * 企业编号
     */
    @ApiModelProperty(value = "企业编号", required = false)
    @Column(name = "c_business_id", columnDefinition = "企业编号")
    private String businessId;

    /**
     * 修改用户
     */
    @ApiModelProperty(value = "修改用户", required = false)
    @Column(name = "c_display_name", columnDefinition = "修改用户")
    private String displayName;

    /**
     * 修改用户
     */
    @ApiModelProperty(value = "修改用户", required = false)
    @Column(name = "c_modify_user", columnDefinition = "修改用户")
    private String modifyUser;

    /**
     * 创建用户
     */
    @ApiModelProperty(value = "创建用户", required = false)
    @Column(name = "c_create_user", columnDefinition = "创建用户")
    private String createUser;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间", required = false)
    @Column(name = "c_create_time", columnDefinition = "创建时间")
    private Date createTime;

    /**
     * 修改时间
     */
    @ApiModelProperty(value = "修改时间", required = false)
    @Column(name = "c_modify_time", columnDefinition = "修改时间")
    private Date modifyTime;
}
