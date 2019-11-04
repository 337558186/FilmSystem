package com.springboot.service.impl;

import com.springboot.mapper.ImageMapper;
import com.springboot.pojo.Image;
import com.springboot.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ：ZWQ
 * @version ：1.0
 * @date ：2019/10/22 - 10:44
 * @description ：
 */
@Service("imageService")
public class ImageServiceImpl implements ImageService {

    @Autowired
    ImageMapper imageMapper;

    @Override
    public int saveImage(Image image) {
        int i = imageMapper.saveImage(image);

        return i;
    }
}
