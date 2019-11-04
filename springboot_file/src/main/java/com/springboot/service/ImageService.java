package com.springboot.service;

import com.springboot.pojo.Image;

/**
 * @author ：ZWQ
 * @version ：1.0
 * @date ：2019/10/22 - 10:44
 * @description ：
 */
public interface ImageService {
    /**
     * 将图片名保存至数据库
     * @param image
     * @return
     */
    int saveImage(Image image);
}
