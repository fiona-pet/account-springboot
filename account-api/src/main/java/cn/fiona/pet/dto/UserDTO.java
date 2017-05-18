package cn.fiona.pet.dto;

import cn.fiona.pet.entity.User;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 * Created with IntelliJ IDEA.
 * User: mq
 * Date: 2017/5/11
 * Time: 17:15
 * To change this template use File | Settings | File Templates.
 */
@ToString
@Setter
@Getter
public class UserDTO {

    /**
     * 编号
     */
    private String id;

    /**
     * 企业名称
     */
    private String name;

    /**
     * 修改用户
     */
    private String displayName;

    /**
     * 修改用户
     */
    private String modifyUser;

    /**
     * 创建用户
     */
    private String createUser;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date modifyTime;

    /**
     * 性别
     */
    private String sex;

    /**
     * 头像
     */
    private String icon;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 电话
     */
    private String phone;

    /**
     * 是否自定义
     */
    private Boolean isCustom;

    /**
     * 备注
     */
    private String memo;

    /**
     * 企业编号
     */
    private String businessId;

    /**
     * 企业名称
     */
    private String businessName;
}
