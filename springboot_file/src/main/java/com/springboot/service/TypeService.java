package com.springboot.service;

import com.springboot.pojo.Type;

import java.util.List;

/**
 * @author ：ZWQ
 * @version ：1.0
 * @date ：2019/10/23 - 10:49
 * @description ：
 */
public interface TypeService {

    /**
     * 所有种类
     * @return
     */
    List<Type> typeList();
}
