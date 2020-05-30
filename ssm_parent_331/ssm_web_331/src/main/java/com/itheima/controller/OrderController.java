package com.itheima.controller;

import com.itheima.domain.Order;
import com.itheima.domain.Product;
import com.itheima.service.OrderService;
import com.itheima.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    /**
     * 查询所有订单
     * @return
     */
    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        //查询所有订单数据
        List<Order> orderList = orderService.findAll();
        //创建ModelAndView对象
        ModelAndView modelAndView = new ModelAndView();
        //添加数据
        modelAndView.addObject("orderList",orderList);
        //指定页面
        modelAndView.setViewName("order-list");
        return modelAndView;
    }

    @Autowired
    ProductService productService;

    /**
     * 添加订单数据回显
     * @return
     */
    @RequestMapping("/addUI")
    public ModelAndView addUI(){
        //查询所有的产品数据
        List<Product> productList = productService.findAll();
        //创建ModelAndView对象
        ModelAndView modelAndView = new ModelAndView();
        //添加数据
        modelAndView.addObject("productList", productList);
        //指定页面
        modelAndView.setViewName("order-add");
        return modelAndView;
    }

    /**
     * 保存订单
     * @param order
     * @return
     */
    @RequestMapping("/save")
    public String add(Order order){
        //保存操作
        orderService.save(order);
        //请求查询全部
        return "redirect:/order/findAll";
    }
}
