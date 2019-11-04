package com.springboot.mapper;

import com.springboot.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ：ZWQ
 * @version ：1.0
 * @date ：2019/10/10 - 14:39
 * @description ：
 */

@Repository
public interface UserMapper {

    /**
     * 用户登录，根据用户名查询用户
     */
    User getUserByUsername(@Param("username") String username);

    /**
     * 用户注册
     * @param user
     * @return
     */
    int insertUser(User user);

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    int     updateUser(User user);

    /**
     * 根据ID删除用户
     * @param user
     * @return
     */
    int deleteUser(User user);

    /**
     * 根据id查询用户
     * @param id
     * @return
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
