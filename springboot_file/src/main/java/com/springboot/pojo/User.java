package com.springboot.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ：ZWQ
 * @version ：1.0
 * @date ：2019/10/10 - 11:45
 * @description ：
 */

@Data
public class User implements Serializable {

    private Integer userId;
    private String userName;
    private  String password;
    private String phone;
    private Date date;
    private Integer state;    //用户状态   0：使用（默认）  1：停用
    private Integer memberId;  //会员信息（默认1级）
    private Integer roleId;    //用户角色  1：普通  2：管理员   3：超管
    private Integer integral;  //会员积分

}
