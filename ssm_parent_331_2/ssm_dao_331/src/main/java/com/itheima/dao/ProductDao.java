package com.itheima.dao;

import com.itheima.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
public interface ProductDao {

    @Select("select * from product")
    List<Product> findAll();

//    @Insert("insert into product values(product_seq.nextval , #{productNum},#{productName},#{cityName},#{departureTime}, #{productPrice},#{productDesc}, #{productStatus})")
//    keyProperty:主键属性名
//    keyColumn:主键列名
//    keyColumn:主键列名
//    before:在添加之前true/之后false获取主键
//    resultType: 主键的类型
//    statement: 获取主键的sql语句
        //mysql:select last_insert_id();
        // oracle: select product_seq.nextval from dual
    @Insert("insert into product values(#{id} , #{productNum},#{productName},#{cityName},#{departureTime}, #{productPrice},#{productDesc}, #{productStatus})")
    @SelectKey(keyProperty = "id",keyColumn = "id",before = false,resultType = Integer.class,
    statement = "select last_insert_id()")
    void save(Product product);

    /** to_char(departureTime,'yyyy-mm-dd hh24:mi') departureTimeStr
     * 根据id查询
     * @param id
     * @return
     */
    @Select("select p.* from product p where id = #{abc}")
    Product findById(Integer id);

    /**
     * 更新产品
     * @param product
     */
    @Update("update product set productNum=#{productNum},productName=#{productName},cityName=#{cityName},departureTime=#{departureTime}, productPrice=#{productPrice},productDesc=#{productDesc}, productStatus=#{productStatus} where id = #{id}")
    void update(Product product);

    /**
     * 根据id删除产品
     * @param id
     */
    @Delete("delete from product where id = #{abc}")
    void delById(Integer id);

    /**
     * 查询总的记录数
     *
     * count(*): 效率最低
     * count(主键)
     * count(1)
     * @return
     */
    @Select("select count(1) from product")
    Long findTotalCount();

    /**
     * 分页查询数据
     * @param startIndex
     * @param endIndex
     * @return
     */
    //@Select("select t.* from (select p.*,rownum rn from product p) t where t.rn between #{param1} and #{param2}")
    @Select("SELECT * FROM product ORDER BY id LIMIT #{param1} , #{param2}")
    List<Product> findByPage(Integer startIndex, Integer endIndex);
}
