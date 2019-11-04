package com.springboot.controller;

import com.springboot.pojo.User;
import com.springboot.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author ：ZWQ
 * @version ：1.0
 * @date ：2019/10/10 - 14:47
 * @description ：
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 登录方法
     * @param user1
     * @param request
     * @return ModelAndView
     */
    @RequestMapping("/login")
    public User login(@RequestBody User user1, HttpServletRequest request){

        //System.out.println(user1.getUserName()+" "+user1.getPassword());
        User user = userService.getUserByUsername(user1.getUserName(), user1.getPassword());
        //System.out.println("------------------------------"+user);
        if(user==null){
            return null;
        }
        log.info(user.getUserName()+"登录成功");
        HttpSession session = request.getSession();
        session.setAttribute("user",user);
        return user;
    }


    /**
     * 注册的方法
     * @param user
     * @param request
     * @return
     */
    @RequestMapping("/registered")
    public Integer registered(@RequestBody User user,HttpServletRequest request){

        List<String> names = userService.nameList();
        for(String name:names){
            if(user.getUserName() ==name){
                System.out.println("用户名已经存在");
                return 0;
            }
        }

        HttpSession session = request.getSession();
        boolean b = userService.insertUser(user);

        if(b){
            System.out.println("注册成功");
            return  1;
        }
        return 0;
    }

    /**
     * 更新用户
     * @param user
     * @return
     */
    @RequestMapping("/update")
    public String updateUser(@RequestBody User user){

        System.out.println(user);
        boolean b = userService.updateUser(user);
        if(b){
            return "success";
        }
        return "failed";
    }

    /**
     * 删除用户
     * @param user
     */
    @RequestMapping("/delete")
    public String deleteUser(@RequestBody User user){

        System.out.println(user);
        boolean b = userService.deleteUser(user);
        if(b){
            return "success";
        }
        return "failed";
    }

    @RequestMapping("/userList")
    public List<User> userList(){


        List<User> users = userService.userList();
        for(User user:users){
           // System.out.println(user);
        }
        return users;

    }


}
