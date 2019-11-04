package com.springboot.controller;

import com.springboot.pojo.Type;
import com.springboot.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ：ZWQ
 * @version ：1.0
 * @date ：2019/10/23 - 10:47
 * @description ：
 */
@RestController
@RequestMapping("/type")
public class TypeController {

    @Autowired
    TypeService typeService;

    @RequestMapping("/typeList")
    public List<Type> typeList(){

        List<Type> types = typeService.typeList();
        //System.out.println(types);
        return types;
    }

    @RequestMapping("/typeList1")
    public List<Type> typeList1(){

        List<Type> types = typeService.typeList();
        //System.out.println(types);
        types.remove(0);
        return types;
    }

}
