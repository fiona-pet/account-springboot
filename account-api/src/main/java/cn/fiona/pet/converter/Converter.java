package cn.fiona.pet.converter;

import cn.fiona.pet.dto.ListFilter;
import cn.fiona.pet.dto.PageSearch;
import cn.fiona.pet.dto.UserRoleDTO;
import org.springframework.data.domain.Page;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by X on 2017/4/17.
 * DTO与Entiry类型转换
 */
public interface Converter<DTO, ENTITY> {

    DTO doForward(ENTITY b);

    void forwardAfter(final DTO dto,final ENTITY entity);

    ENTITY doBackward(DTO dto);

    void backwardAfter(final DTO dto,final ENTITY entity);

    List<DTO> doForwardList(List<ENTITY> list);

    List<ENTITY> doBackwardList(List<DTO> list);


    void filter(final ListFilter pageSearch);

    Map<String, String> toEntityKey();
}
