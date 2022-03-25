package com.flywolf.li.sales.dou.service;

import com.flywolf.li.sales.dou.service.bo.DouBO;

import java.util.List;

public interface DouService {
    /**
     * 创建分销组织
     *
     * @param bo
     * @return
     */
    public Long register(DouBO bo);

    /**
     * 更新分销组织
     *
     * @param bo
     */
    public void update(DouBO bo);

    /**
     * 删除分销组织
     *
     * @param douid
     */
    public void delete(Long douid);

    /**
     * 根据id查找分销组织
     *
     * @param douid
     * @return
     */
    public DouBO findById(Long douid);

    /**
     * 获取所有分销组织信息
     * @return
     */
    public List<DouBO> findAll();
}
