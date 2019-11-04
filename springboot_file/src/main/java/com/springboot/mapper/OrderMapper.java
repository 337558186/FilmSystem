package com.springboot.mapper;

import com.springboot.pojo.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ：ZWQ
 * @version ：1.0
 * @date ：2019/10/22 - 19:31
 * @description ：
 */

@Repository
public interface OrderMapper {

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
    List<Order> getById(Order order);
}
