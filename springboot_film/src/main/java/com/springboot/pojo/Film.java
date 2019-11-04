package com.springboot.pojo;


import lombok.Data;

import java.util.Date;

/**
 * 电影类
 */

@Data
public class Film {

  private Integer filmId;
  private String filmName;
  private String director;
  private Integer duration;  /*电影时长*/
  private Date date;
  private Double price;
  private Type type;   /*电影类型*/
  private Image image;   /*预览图*/
  private Save save;    /*保存位置*/

  private Comments comments;


}
