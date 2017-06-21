package cn.fiona.pet.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户和角色关系信息
 *
 * <p>
 * Created by tom on 2017-06-02 10:37:08.
 */
@ApiModel("用户和角色关系信息")
@ToString
@Setter
@Getter
public class UserRoleDTO{

    @ApiModelProperty(value = "id")
    private String id;

    
    /**
     * 
     */
    @ApiModelProperty(value = "", required = false)
     private String userId;
    
    /**
     * 
     */
    @ApiModelProperty(value = "", required = false)
     private String roleId;

    public static final Map<String, String> toEntityKey(){
        Map<String, String> toEntityKey = new HashMap<String, String>();

        toEntityKey.put("userId", "user.id");
        toEntityKey.put("roleId", "role.id");

        return toEntityKey;
    }
    
}