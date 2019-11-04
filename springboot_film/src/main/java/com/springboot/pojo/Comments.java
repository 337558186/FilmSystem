package com.springboot.pojo;

import lombok.Data;

/**
 * 电影评论类
 */
@Data
public class Comments {

  private Integer id;
  private Integer userId;
  private Integer filmId;
  private String content;   /*内容*/
  private Integer score;    /*分数*/

  private User user;
  private Film film;
}
