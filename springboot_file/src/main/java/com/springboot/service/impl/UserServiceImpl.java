package com.springboot.service.impl;

import com.springboot.mapper.UserMapper;
import com.springboot.pojo.User;
import com.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：ZWQ
 * @version ：1.0
 * @date ：2019/10/10 - 14:44
 * @description ：
 */

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User getUserByUsername(String username, String password) {

        User user = userMapper.getUserByUsername(username);
        if(user.getPassword().equals(password)){
            return user;
        }
        return null;
    }


    @Override
    public boolean insertUser(User user) {

        int i = userMapper.insertUser(user);
        if(i>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        int i = userMapper.updateUser(user);
        if(i>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteUser(User user) {

        int i = userMapper.deleteUser(user);
        if(i>0){
            return true;
        }
        return false;
    }

    @Override
    public User findUserById(Integer id) {

        User user = userMapper.findUserById(id);
        return user;
    }

    @Override
    public List<User> userList() {
        List<User> users = userMapper.userList();
        return users;
    }

    @Override
    public List<String> nameList() {

        List<String> names = userMapper.nameList();
        return names;
    }
}
