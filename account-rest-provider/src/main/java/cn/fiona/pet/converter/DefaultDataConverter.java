package cn.fiona.pet.converter;

import cn.fiona.pet.dto.ListFilter;
import cn.fiona.pet.dto.PageSearch;
import cn.fiona.pet.dto.SearchFilter;
import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: tom
 * Date: 2017/5/12
 * Time: 11:42
 * To change this template use File | Settings | File Templates.
 */
@Component
public abstract class DefaultDataConverter<dto, entity> implements Converter<dto, entity> {
    private dto newDto() {
        dto d;
        try {
            // 通过反射获取model的真实类型
            ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
            Class<dto> clazz = (Class<dto>) pt.getActualTypeArguments()[0];
            // 通过反射创建model的实例
            d = clazz.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return d;
    }

    private entity newEntity() {
        entity entity;
        try {
            // 通过反射获取model的真实类型
            ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
            Class<entity> clazz = (Class<entity>) pt.getActualTypeArguments()[1];
            // 通过反射创建model的实例
            entity = clazz.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return entity;
    }

    @Override
    public dto doForward(entity entity) {
        dto dtoObject = newDto();
        if (null != entity) {
            BeanUtils.copyProperties(entity, dtoObject);
        }

        forwardAfter(dtoObject, entity);

        return dtoObject;
    }

    @Override
    public entity doBackward(dto dto) {
        entity entity = newEntity();
        BeanUtils.copyProperties(dto, entity);

        backwardAfter(dto, entity);
        return entity;
    }

    @Override
    public void backwardAfter(dto dto, final entity entity) {
    }

    @Override
    public List<dto> doForwardList(List<entity> list) {
        List<dto> result = Lists.newArrayList();
        for (entity entity : list) {
            result.add(this.doForward(entity));
        }
        return result;
    }

    @Override
    public List<entity> doBackwardList(List<dto> list) {
        List<entity> result = Lists.newArrayList();
        for (dto dto : list) {
            result.add(this.doBackward(dto));
        }
        return result;
    }

    @Override
    public void forwardAfter(dto a, entity entity) {

    }

    @Override
    public void filter(@NotNull ListFilter listFilter) {
        for (Map.Entry<String, String> entry: toEntityKey().entrySet()){
            toEntityKey(entry,listFilter.getFilters());
            toEntityKey(entry,listFilter.getAndFilters());
        }
    }

    private void toEntityKey(Map.Entry<String, String> entry, List<SearchFilter> filters){
        if (null == filters){
            return;
        }

        for (SearchFilter filter: filters){
            if (entry.getKey().equals(filter.getFieldName())){
                filter.setFieldName(entry.getValue());
            }
        }
    }

    public Map<String, String> toEntityKey(){
        return new HashMap<String,String>();
    }
}
