package cn.fiona.pet.facade;

import cn.fiona.pet.converter.Converter;
import cn.fiona.pet.converter.DefaultDataConverter;
import cn.fiona.pet.dto.ListFilter;
import cn.fiona.pet.dto.PageSearch;
import cn.fiona.pet.dto.RestResult;
import cn.fiona.pet.service.CURDService;

import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.ListUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.Iterator;
import java.util.List;

/**
 * DTO转化你的基本实现
 * Created by X on 2017/4/17.
 */
public abstract class ConverterRestServiceBase<A, B> extends DefaultDataConverter<A, B> implements CURDRestService<A>, Converter<A, B> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConverterRestServiceBase.class);

    public abstract CURDService<B> getService();

    @Override
    public RestResult<List<A>> list(ListFilter listFilter) {
        filter(listFilter);

        List<B> list = this.getService().list(listFilter);
        LOGGER.debug("list:{}", list);
        List<A> dtoList = doForwardList(list);
        LOGGER.debug("dtoList:{}", dtoList);
        return RestResult.OK(dtoList);
    }

    @Override
    public RestResult<Page<A>> page(PageSearch pageSearch) {
        filter(pageSearch);

        Page page = this.getService().page(pageSearch);
        LOGGER.debug("pageSearch:{} => {}", pageSearch, page);

        Page result  = page.map(new org.springframework.core.convert.converter.Converter() {
            @Override
            public Object convert(Object o) {
                return doForward((B)o);
            }
        });

        LOGGER.debug("dtoPageSearch:{} => {}", pageSearch, page);
        return RestResult.OK(result);
    }

    @Override
    public RestResult<A> create(A petRace) {
        LOGGER.debug("create or update :{}", petRace);
        B entity = doBackward(petRace);

        this.getService().createOrUpdte(entity);

        A restult = doForward(entity);

        return RestResult.OK(restult);
    }

    @Override
    public RestResult<String> delete(String uuid) {
        LOGGER.debug("delete :{}", uuid);
        this.getService().delete(uuid);
        return RestResult.OK("删除成功!");
    }

    @Override
    public RestResult<A> detail(String uuid) {
        B entity = getService().detail(uuid);
        A dto = doForward(entity);
        return RestResult.OK(dto);
    }
}
