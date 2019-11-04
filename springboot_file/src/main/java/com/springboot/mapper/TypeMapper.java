package com.springboot.mapper;

import com.springboot.pojo.Type;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ：ZWQ
 * @version ：1.0
 * @date ：2019/10/23 - 10:47
 * @description ：
 */
@Repository
public interface TypeMapper {

    /**
     * 所有种类
     * @return
     */
    List<Type> typeList();
}
