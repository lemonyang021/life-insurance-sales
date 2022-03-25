package com.flywolf.li.framework.util;

import com.flywolf.li.framework.entity.BaseEntity;
import lombok.experimental.UtilityClass;
import org.springframework.beans.BeanUtils;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class ConvertUtil {

    /**
     * 初始插入
     *
     */
    public static void initInsertEntity(BaseEntity baseEntity) {
        baseEntity.setInsertedBy(401L);
        baseEntity.setUpdatedBy(401L);
        baseEntity.setInsertTime(new Date());
        baseEntity.setUpdateTime(new Date());
    }

    /**
     * 初始更新
     *
     */
    public static void initUpdateEntity(BaseEntity baseEntity) {
        baseEntity.setUpdatedBy(401L);
        baseEntity.setUpdateTime(new Date());
    }

    public static <T, V> T convert(V v, Class<T> classT) {
        T t = null;
        try {
            t = classT.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        assert t != null;
        BeanUtils.copyProperties(v, t);
        return t;
    }

    public static <T, V> List<T> convert(List<V> vList, Class<T> classT) {
        return vList.stream().map(e ->
                convert(e, classT)
        ).collect(Collectors.toList());
    }
}
