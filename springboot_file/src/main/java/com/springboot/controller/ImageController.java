package com.springboot.controller;

import com.springboot.pojo.Image;
import com.springboot.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author ：ZWQ
 * @version ：1.0
 * @date ：2019/10/22 - 10:46
 * @description ：
 */
@RestController
@RequestMapping("/image")
public class ImageController {

    @Autowired
    ImageService imageService;

    /*电影预览图上传*/
    @PostMapping("/upload")
    @ResponseBody
    public int upload(@RequestParam("file") MultipartFile upload, HttpServletRequest request) throws IOException {

       // System.out.println("开始上传");
        if (upload.isEmpty()) {
            return 0;
        }

        String path = "D:/uploads/images/";
        //String path = request.getSession().getServletContext().getRealPath("/uploads/");
        // 判断，该路径是否存在
        File file = new File(path);
        if(!file.exists()){
            // 创建该文件夹
            file.mkdirs();
        }
        // 说明上传文件项  ， 获取上传文件的名称
        String filename = upload.getOriginalFilename();
        // 把文件的名称设置唯一值，uuid
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String sname = filename.substring(filename.lastIndexOf("."));  //获得文件的后缀名
        filename = uuid+"_"+sname;
        // 完成文件上传
        upload.transferTo(new File(path,filename));
        System.out.println(filename);
        System.out.println(path);

        //将图片url保存至数据库
        Image image = new Image();
        image.setImageUrl("http://localhost:8080/resources/" + filename);

       // System.out.println(image.getImageUrl());

        int i = imageService.saveImage(image);
        System.out.println(image.getImageId());


        return image.getImageId();
    }
}
