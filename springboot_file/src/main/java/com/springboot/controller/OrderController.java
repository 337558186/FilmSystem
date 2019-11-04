package com.springboot.controller;

import com.springboot.pojo.Order;
import com.springboot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ：ZWQ
 * @version ：1.0
 * @date ：2019/10/22 - 19:36
 * @description ：
 */

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    /**
     * 添加订单
     * @param order
     * @return
     */
    @RequestMapping("/add")
    public String addOrder(@RequestBody Order order){

        //System.out.println(order);
        int i = orderService.addOrder(order);
        //System.out.println(i);
        if(i>0){
            return "success";
        }
        return "failed";
    }

    /**
     * 查询订单
     * @param order
     * @return
     */
    @RequestMapping("/show")
    public List<Order> show(@RequestBody Order order){
       // System.out.println(order.getUser());
        List<Order> orders = orderService.show(order);
        //System.out.println(orders);
        return orders;

    }

    /**
     * 查询用户是否已经购买该电影
     * @param order
     * @return
     */
    @RequestMapping("/query")
    public String getbyId(@RequestBody Order order){

       // System.out.println(order);
        boolean b = orderService.getById(order);
        //System.out.println(b);
        if(b){
            return "success";
        }
        return "failed";
    }

    /**
     *
     * @param order
     * @return
     */
    @RequestMapping("/getById")
    public String getOrderbyId(@RequestBody Order order){

        System.out.println(order);
        boolean b = orderService.getById(order);
        if(b){
            return "success";
        }

        return null;
    }
}
