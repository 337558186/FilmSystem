package com.springboot.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author ：ZWQ
 * @version ：1.0
 * @date ：2019/10/24 - 9:11
 * @description ：观看历史
 */

@Data
public class History {

    private Integer id;
    private User user;
    private Film film;
    private Date date;  /*观看时间*/
    private Integer userId;
    private Integer filmId;
}
