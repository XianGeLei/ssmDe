package com.itheima.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.PageBean;
import com.itheima.domain.Product;
import com.itheima.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    /**
     * 分页助手查询
     *
     * RequestParam; 请求参数绑定
     *      name:别名value, 指定页面参数的名称
     *      required: 是否必要参数
     * @return
     */
    @RequestMapping("/findAll")
    public ModelAndView findAll(
            @RequestParam(value = "currPage",required = false, defaultValue = "1")  Integer currPage ,
            @RequestParam(value = "pageSize",required = false, defaultValue = "5")Integer pageSize){
        //准备数据: 分页数据
        PageInfo<Product> pageInfo = productService.findByPageHelper(currPage, pageSize);
        //创建ModelAndView对象
        ModelAndView modelAndView = new ModelAndView();
        //添加数据
        modelAndView.addObject("pageInfo",pageInfo);
        //指定页面
        modelAndView.setViewName("product-list");
        return modelAndView;
    }

    /**
     * 手动分页查询
     *
     * RequestParam; 请求参数绑定
     *      name:别名value, 指定页面参数的名称
     *      required: 是否必要参数
     * @return
     */
    @RequestMapping("/findAll2")
    public ModelAndView findAll2(
            @RequestParam(value = "currPage",required = false, defaultValue = "1")  Integer currPage ,
            @RequestParam(value = "pageSize",required = false, defaultValue = "5")Integer pageSize){
        //准备数据: 分页数据
        PageBean<Product> pageBean = productService.findByPage(currPage,pageSize);
        //创建ModelAndView对象
        ModelAndView modelAndView = new ModelAndView();
        //添加数据
        modelAndView.addObject("pageBean",pageBean);
        //指定页面
        modelAndView.setViewName("product-list");
        return modelAndView;
    }

    /**
     * 查询全部
     * @return
     */
    @RequestMapping("/findAll1")
    public ModelAndView findAll1(){
        //准备数据
        List<Product>  productList = productService.findAll();
        //创建ModelAndView对象
        ModelAndView modelAndView = new ModelAndView();
        //添加数据
        modelAndView.addObject("productList",productList);
        //指定页面
        modelAndView.setViewName("product-list");
        return modelAndView;
    }

    /**
     * 保存产品
     * @return
     */
    @RequestMapping("/save")
    public String save(Product product){
        //保存操作
        productService.save(product);
        //请求查询全部
        return "redirect:/product/findAll";
    }

    /**
     * 更新数据回显
     * @param id
     * @return
     */
    @RequestMapping("/updateUI")
    public ModelAndView updateUI(Integer id){
        //根据id查询产品对象
        Product product = productService.findById(id);
        //创建ModelAndView对象
        ModelAndView modelAndView = new ModelAndView();
        //添加数据
        modelAndView.addObject("product", product);
        //指定页面
        modelAndView.setViewName("product-update");
        return  modelAndView;
    }

    /**
     * 更新产品
     * @param product
     * @return
     */
    @RequestMapping("/update")
    public String update(Product product){
        //更新操作
        productService.update(product);
        //请求查询全部
        return "redirect:/product/findAll";
    }

    /*
    删除单个产品
     */
    @RequestMapping("/delOne")
    public String delOne(Integer id){
        //执行删除操作
        productService.delOne(id);
//        请求查询全部
        return "redirect:/product/findAll";
    }

    /**
     * 删除多个产品
     * @param ids
     * @return
     */
    @RequestMapping("/delMany")
    public String delMany(Integer[] ids){
        //执行删除操作
        productService.delMany(ids);
        //请求查询全部
        return "redirect:/product/findAll";
    }
}
