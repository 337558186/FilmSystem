package com.springboot.service.impl;

import com.springboot.mapper.OrderMapper;
import com.springboot.pojo.Order;
import com.springboot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：ZWQ
 * @version ：1.0
 * @date ：2019/10/22 - 19:35
 * @description ：
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;

    @Override
    public int addOrder(Order order) {
        int i = orderMapper.addOrder(order);
        return i;
    }

    @Override
    public List<Order> show(Order order) {
        List<Order> orders = orderMapper.show(order);
        return orders;
    }

    @Override
    public boolean getById(Order order) {

        List<Order> orders = orderMapper.getById(order);
        System.out.println(orders);

        if(!orders.isEmpty()){
            return true;
        }
        return false;
    }
}
