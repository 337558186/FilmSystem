package com.springboot.service.impl;

import com.springboot.mapper.TypeMapper;
import com.springboot.pojo.Type;
import com.springboot.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：ZWQ
 * @version ：1.0
 * @date ：2019/10/23 - 10:50
 * @description ：
 */

@Service("typeService")
public class TypeServiceImpl implements TypeService {

    @Autowired
    TypeMapper typeMapper;

    @Override
    public List<Type> typeList() {

        List<Type> types = typeMapper.typeList();
        return types;
    }
}
