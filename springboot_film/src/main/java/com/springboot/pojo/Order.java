package com.springboot.pojo;

import lombok.Data;

/**
 * 电影订单类
 */

@Data
public class Order {

  private Integer orderId;
  private Integer userId;
  private Integer filmId;
  private User user;
  private Film film;

}
