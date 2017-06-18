package cn.fiona.pet.converter;

import java.util.List;

/**
 * Created by X on 2017/4/17.
 * DTO与Entiry类型转换
 */
public interface Converter<DTO, ENTITY> {

    DTO doForward(ENTITY b);

    void forwardAfter(final DTO a,final ENTITY entity);

    ENTITY doBackward(DTO a);

    void backwardAfter(final ENTITY b);

    List<DTO> doForwardList(List<ENTITY> list);

    List<ENTITY> doBackwardList(List<DTO> list);
}
