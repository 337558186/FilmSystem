package com.springboot.service.impl;

import com.springboot.mapper.CommentsMapper;
import com.springboot.pojo.Comments;
import com.springboot.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：ZWQ
 * @version ：1.0
 * @date ：2019/10/25 - 13:06
 * @description ：
 */

@Service("commentsService")
public class CommentsServiceImpl implements CommentsService {

    @Autowired
    CommentsMapper commentsMapper;

    @Override
    public int addComment(Comments comments) {

        int i = commentsMapper.addComment(comments);
        return i;
    }

    @Override
    public List<Comments> showComments(Comments comments) {
        List<Comments> comments1 = commentsMapper.showComments(comments);
        return comments1;
    }
}
