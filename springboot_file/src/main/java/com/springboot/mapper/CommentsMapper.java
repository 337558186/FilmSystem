package com.springboot.mapper;

import com.springboot.pojo.Comments;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ：ZWQ
 * @version ：1.0
 * @date ：2019/10/25 - 13:00
 * @description ：
 */

@Repository
public interface CommentsMapper {

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
