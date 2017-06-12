package cn.fiona.pet.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户信息
 * <p>
 * <p>
 * Created by tom on 2017-05-19 14:31:34.
 */
@ApiModel("用户信息")
@ToString
@Setter
@Getter
public class MenuDTO implements Serializable {
    @ApiModelProperty("id")
    private String id;

    public MenuDTO(Object source) {
        BeanUtils.copyProperties(source, this);
    }

    @ApiModelProperty("名称")
    private String name;
    @ApiModelProperty("编码")
    private String code;
    @ApiModelProperty("叶子节点")
    private boolean leaf;
    @ApiModelProperty("排序")
    private int order;
    @ApiModelProperty("图标样式")
    private String iconClass;
    @ApiModelProperty("地址")
    private String uri;
    @ApiModelProperty("子菜单")
    private List<MenuDTO> subMenu = new ArrayList<MenuDTO>();
}