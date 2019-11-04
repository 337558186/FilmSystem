package com.springboot.service;

import com.springboot.pojo.Order;

import java.util.List;

/**
 * @author ：ZWQ
 * @version ：1.0
 * @date ：2019/10/22 - 19:34
 * @description ：
 */
public interface OrderService {

    /**
     * 添加订单
     * @param order
     * @return
     */
    int addOrder(Order order);

    /**
     * 查询订单
     * @param order
     * @return
     */
    List<Order> show(Order order);

    /**
     * 根据Id查询
     * @param order
     * @return
     */
    boolean getById(Order order);
}
