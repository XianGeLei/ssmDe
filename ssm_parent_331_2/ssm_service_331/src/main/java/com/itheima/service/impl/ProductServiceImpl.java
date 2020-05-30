package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.dao.ProductDao;
import com.itheima.domain.PageBean;
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

    @Override
    public PageBean<Product> findByPage(Integer currPage, Integer pageSize) {
        //创建PageBean对象
        PageBean<Product> pageBean = new PageBean<>();
        //封装PageBean
//    当前页 --- 页面传参
//        private Integer currPage;
        pageBean.setCurrPage(currPage);
//    每页条数 -- 页面传参
//        private Integer pageSize;
        pageBean.setPageSize(pageSize);
//    总条数 -- 数据库查询
//        private Long totalCount;
        Long totalCount = productDao.findTotalCount();
        pageBean.setTotalCount(totalCount);
//    总页数 -- 计算
        // Math.ceil(totalCount * 1.0 / pageSize)
//        private Integer totalPage;
        pageBean.setTotalPage((int)Math.ceil(totalCount * 1.0 / pageSize));
//    当前页数据 -- 数据库查询
//        private List<T> list;
        /** 每页展示5条数据
         * 第一页： 1   5
         * 第二页： 6   10
         * 第三页：11  15
         * 第n页： 5n-(5-1)    5n
         * currPage ===> n
         * pageSize ==> 5
         * 第n页：pageSize * currPage-(pageSize-1)=pageSize(currPage-1) +1
         *  currPage*pageSize
         */
        //oracle
        //Integer startIndex = pageSize*(currPage-1) +1;
        //Integer endIndex = currPage*pageSize;
        Integer startIndex = pageSize*(currPage-1) ;
        Integer endIndex = pageSize;
        List<Product> productList = productDao.findByPage(startIndex, endIndex);
        pageBean.setList(productList);
        return pageBean;
    }

    @Override
    public PageInfo<Product> findByPageHelper(Integer currPage, Integer pageSize) {
//        指定分页参数
        PageHelper.startPage(currPage, pageSize);
//        查询全部
        List<Product> productList = productDao.findAll();
//        创建PageInfo对象
        PageInfo<Product> pageInfo = new PageInfo<>(productList,3);

        return pageInfo;
    }

    @Override
    public void testFindByPageHelper(Integer currPage, Integer pageSize) {
//        为分页助手初始化参数
        PageHelper.startPage(currPage, pageSize);
//        查询全部
        List<Product> productList = productDao.findAll();
        System.out.println("ddd"+productList.size());
//        创建PageInfo对象 -- 相当于自定义PageBean :需要通过构造传入查询的集合对象 , 页面最多显示5个页码
        PageInfo<Product> pageInfo = new PageInfo<>(productList, 5);
        System.out.println("当前页:"+ pageInfo.getPageNum());
        System.out.println("每页条数:"+ pageInfo.getPageSize());
        System.out.println("总页数:"+ pageInfo.getPages());
        System.out.println("总条数:"+ pageInfo.getTotal());
        System.out.println("数据:"+ pageInfo.getList().size());
        System.out.println("上一页页码:"+ pageInfo.getPrePage());
        System.out.println("下一页页码:"+ pageInfo.getNextPage());
        System.out.println("是否第一页:"+ pageInfo.isIsFirstPage());
        System.out.println("是否最后一页:"+ pageInfo.isIsLastPage());
        System.out.println("页面显示的第一个页码："+pageInfo.getNavigateFirstPage());
        System.out.println("页面显示的最后一个页码："+pageInfo.getNavigateLastPage());

    }
}
