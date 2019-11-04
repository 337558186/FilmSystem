package com.springboot.service;

import com.springboot.pojo.User;

import java.util.List;

/**
 * @author ：ZWQ
 * @version ：1.0
 * @date ：2019/10/10 - 14:43
 * @description ：
 */
public interface UserService {

    /**
     * 用户登录，根据用户名查询用户
     * @param username
     * @return User
     */
    User getUserByUsername(String username,String password);

    /**
     * 用户注册
     * @param user
     * @return
     */
    boolean insertUser(User user);

    /**
     * 更新用户
     * @param user
     * @return
     */
    boolean updateUser(User user);
    /**
     * 删除用户
     */
    boolean deleteUser(User user);
    /**
     * 根据id查询用户
     */
    User findUserById(Integer id);

    /**
     * 查询所有用户
     * @return
     */
    List<User> userList();

    /**
     * 查询所有用户名---注册用户名不可以重复
     */
    List<String> nameList();
}
