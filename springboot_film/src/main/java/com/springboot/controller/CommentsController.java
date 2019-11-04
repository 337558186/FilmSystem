package com.springboot.controller;

import com.springboot.pojo.Comments;
import com.springboot.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ：ZWQ
 * @version ：1.0
 * @date ：2019/10/25 - 12:58
 * @description ：
 */

@RestController
@RequestMapping("/comments")
public class CommentsController {

    @Autowired
    CommentsService commentsService;

    /**
     *添加评论
     */
    @RequestMapping("/add")
    public void add(@RequestBody Comments comments){

        System.out.println(comments);
        int i = commentsService.addComment(comments);
        if(i>0){
            System.out.println("添加评论成功");
        }else{
            System.out.println("评论添加失败");
        }
    }


    @RequestMapping("/show")
    public List<Comments> showComments(@RequestBody Comments comments){

        List<Comments> comments1 = commentsService.showComments(comments);
        System.out.println(comments1);
        return comments1;
    }
}
