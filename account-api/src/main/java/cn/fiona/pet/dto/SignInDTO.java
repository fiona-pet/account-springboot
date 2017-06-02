package cn.fiona.pet.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 用户登录
 * Created by tom on 16/1/21.
 */
@Getter
@Setter
@ToString
public class SignInDTO implements Serializable {

    @NotNull
    @Size(min = 1, max = 20)
    @ApiModelProperty(value = "用户名", required = true)
    private String name;
    @ApiModelProperty(value = "密码", required = true)
    private String password;

    @ApiModelProperty(value = "客户端信息", required = false)
    private From from;
}
