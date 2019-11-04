package com.springboot.mapper;

import com.springboot.pojo.History;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ：ZWQ
 * @version ：1.0
 * @date ：2019/10/24 - 9:19
 * @description ：
 */

@Repository
public interface HistoryMapper {

    /**
     * 添加记录
     * @param history
     * @return
     */
    int add(History history);

    /**
     * 查询历史记录
     * @param history
     * @return
     */
    List<History> listHistory(History history);

    /**
     * 清除历史记录
     * @param history
     * @return
     */
    int clearHistory(History history);
}
