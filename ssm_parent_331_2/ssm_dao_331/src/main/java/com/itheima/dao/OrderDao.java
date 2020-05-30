package com.itheima.dao;

import com.itheima.domain.Order;
import com.itheima.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
public interface OrderDao {

    /**
     * 查询全部
     * @return
     */
    @Select("select * from orders")
//    @Results 映射多列数据
//    @Result:映射单列数据
//    select :全限类名+ 方法名 == mapperId
    @Results({
            @Result(property = "product",column = "productId",javaType = Product.class,
            one = @One(select = "com.itheima.dao.ProductDao.findById"))
    })
    List<Order> findAll();

    /**
     * 保存订单 order_seq.nextval
     * @param order
     */
    @Insert("insert into orders values(null,#{orderNum}, #{orderTime}  ,#{peopleCount},#{orderDesc}, #{payType} , #{orderStatus} , #{product.id})")
    void save(Order order);
}
