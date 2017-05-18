package cn.fiona.pet.dto;

/**
 * Created by X on 2017/4/17.
 * DTO与Entiry类型转换
 */
public interface Converter<A, B> {

    A doForward(B b);

    B doBackward(A a);
}
