package cn.fiona.pet.converter;

import java.util.List;

/**
 * Created by X on 2017/4/17.
 * DTO与Entiry类型转换
 */
public interface DataConverter<A, B> {

    A doForward(B b);

    B doBackward(A a);

    List<A> doForwardList(List<B> list);

    List<B> doBackwardList(List<A> list);
}
