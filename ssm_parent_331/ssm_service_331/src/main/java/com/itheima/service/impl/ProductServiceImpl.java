package com.itheima.service.impl;

import com.itheima.dao.ProductDao;
import com.itheima.domain.Product;
import com.itheima.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
@Service
public class ProductServiceImpl implements ProductService

{

    @Autowired
    ProductDao productDao;

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public void save(Product product) {
        productDao.save(product);
    }

    @Override
    public Product findById(Integer id) {
        Product product=productDao.findById(id);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String s=sdf.format(product.getDepartureTime());
        System.out.println("时间"+s);
        product.setDepartureTimeStr(s);
        return product;
    }

    @Override
    public void update(Product product) {
        productDao.update(product);
    }

    @Override
    public void delOne(Integer id) {
        productDao.delById(id);
    }

    @Override
    public void delMany(Integer[] ids) {
        //判断ids是否为null
        if(ids != null){
            //遍历ids，删除多个产品
            for (Integer id : ids) {
                productDao.delById(id);
            }
        }
    }
}
