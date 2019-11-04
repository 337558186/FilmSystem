package com.springboot.mapper;

import com.springboot.pojo.Image;
import org.springframework.stereotype.Repository;

/**
 * @author ：ZWQ
 * @version ：1.0
 * @date ：2019/10/22 - 10:38
 * @description ：电影图片
 */

@Repository
public interface ImageMapper {

    int saveImage(Image image);
}
