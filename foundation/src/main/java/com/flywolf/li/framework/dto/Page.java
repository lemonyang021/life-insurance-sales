package com.flywolf.li.framework.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Page<T> implements Serializable {

    private static final long serialVersionUID = -2071915127870978157L;
    @Schema(title = "每页数量")
    private int size;

    @Schema(title = "页码")
    private int page;

    @Schema(title = "最后页")
    private int endPage;

    @Schema(title = "总数据量")
    private long total;

    @Schema(title = "数据集合")
    private List<T> data;

    public static Page empty() {
        return new Page<>(0, 0, 0, 0, Collections.emptyList());
    }

    /**
     * 集合转分页
     *
     * @param list
     * @param <T>
     * @return
     */
    public static <T> Page<T> listToPage(List<T> list) {
        if (!CollectionUtils.isEmpty(list)) {
            Page<T> searchResult = new Page<>();
            searchResult.setData(list);
            searchResult.setPage(1);
            searchResult.setEndPage(1);
            searchResult.setSize(list.size());
            searchResult.setTotal(list.size());
            return searchResult;
        }
        return new Page<>(0, 0, 0, 0, Collections.emptyList());
    }

    /**
     * 适用于将jpa直接查询到的分页对象转换自定义的分页对象
     *
     * @param pages
     * @param <T>
     * @return
     */
    public static <T> Page<T> by(org.springframework.data.domain.Page<T> pages) {
        if (pages.hasContent()) {
            Page<T> searchResult = new Page<>();
            searchResult.setData(pages.getContent());
            searchResult.setPage(pages.getNumber() + 1);
            searchResult.setEndPage(pages.getTotalPages());
            searchResult.setSize(pages.getSize());
            searchResult.setTotal(pages.getTotalElements());
            return searchResult;
        }
        return new Page<>(0, 0, 0, 0, Collections.emptyList());
    }

    /**
     * 适用于将jpa查询到的分页对象中的data转换成其他BO形式 再转换自定义的分页对象
     *
     * @param pages
     * @param list
     * @param <T>
     * @return
     */
    public static <T> Page<T> of(org.springframework.data.domain.Page pages, List<T> list) {
        if (!CollectionUtils.isEmpty(list)) {
            Page<T> searchResult = new Page<>();
            searchResult.setData(list);
            searchResult.setPage(pages.getNumber() + 1);
            searchResult.setEndPage(pages.getTotalPages());
            searchResult.setSize(pages.getSize());
            searchResult.setTotal(pages.getTotalElements());
            return searchResult;
        }
        return new Page<>(0, 0, 0, 0, Collections.emptyList());
    }
}
