package com.itheima.service;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.PageBean;
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

    /**
     * 根据分页参数查询PageBean对象
     * @param currPage
     * @param pageSize
     * @return
     */
    PageBean<Product> findByPage(Integer currPage, Integer pageSize);

    /**
     * 根据分页助手查询
     * @param currPage
     * @param pageSize
     * @return
     */
    PageInfo<Product> findByPageHelper(Integer currPage, Integer pageSize);

    /**
     * 测试分页助手
     * @param currPage
     * @param pageSize
     */
    public void testFindByPageHelper(Integer currPage, Integer pageSize);
}
