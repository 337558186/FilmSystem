package com.springboot.service;

import com.springboot.pojo.Comments;

import java.util.List;

/**
 * @author ：ZWQ
 * @version ：1.0
 * @date ：2019/10/25 - 13:01
 * @description ：
 */
public interface CommentsService {

    /**
     * 添加评论
     * @param comments
     * @return
     */
    int addComment(Comments comments);

    /**
     * 根据查询所有评论
     * @param comments
     * @return
     */
    List<Comments> showComments(Comments comments);
}
