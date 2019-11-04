package com.springboot.service;

import com.springboot.pojo.History;

import java.util.List;

/**
 * @author ：ZWQ
 * @version ：1.0
 * @date ：2019/10/24 - 9:35
 * @description ：
 */
public interface HistoryService {

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
