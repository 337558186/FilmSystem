package com.springboot.service.impl;

import com.springboot.mapper.HistoryMapper;
import com.springboot.pojo.History;
import com.springboot.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：ZWQ
 * @version ：1.0
 * @date ：2019/10/24 - 9:35
 * @description ：
 */
@Service("historyService")
public class HistoryServiceImpl implements HistoryService {

    @Autowired
    HistoryMapper historyMapper;

    @Override
    public int add(History history) {

        int i = historyMapper.add(history);

        return i;
    }

    @Override
    public List<History> listHistory(History history) {

        List<History> histories = historyMapper.listHistory(history);
        return histories;
    }

    @Override
    public int clearHistory(History history) {
        int i = historyMapper.clearHistory(history);

        return i;
    }
}
