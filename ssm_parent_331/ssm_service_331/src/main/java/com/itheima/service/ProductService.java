package com.itheima.service;

import com.itheima.domain.Product;

import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
public interface ProductService {
    /**
     * 查询全部
     * @return
     */
    List<Product> findAll();

    /**
     * 保存产品
     * @param product
     */
    void save(Product product);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    Product findById(Integer id);

    /**
     * 更新
     * @param product
     */
    void update(Product product);

    /**
     * 删除单个产品
     * @param id
     */
    void delOne(Integer id);

    /**
     * 删除多个产品
     * @param ids
     */
    void delMany(Integer[] ids);
}
