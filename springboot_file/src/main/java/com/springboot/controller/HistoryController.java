package com.springboot.controller;

import com.springboot.pojo.History;
import com.springboot.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ：ZWQ
 * @version ：1.0
 * @date ：2019/10/24 - 9:13
 * @description ：历史记录
 */

@RestController
@RequestMapping("/history")
public class HistoryController {

    @Autowired
    HistoryService historyService;

    /**
     * 添加历史记录
     * @param history
     * @return
     */
    @RequestMapping("/add")
    public String add(@RequestBody History history){


        int i = historyService.add(history);
        if(i>0){
            return "success";
        }

        return null;
    }

    /**
     * 查询历史记录
     * @param history
     * @return
     */
    @RequestMapping("/list")
    public List<History> list(@RequestBody History history){

      /*  System.out.println(history);*/
        List<History> histories = historyService.listHistory(history);
       /* System.out.println(histories);*/
        return  histories;
    }

    /**
     * 清空历史记录
     */
    @RequestMapping("/clear")
    public String clearHistory(@RequestBody History history){

        //System.out.println(history);
        int i = historyService.clearHistory(history);
        if(i>0){
            return "success";
        }
        return null;
    }
}
