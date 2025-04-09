package cn.bugstack.middleware.schedule.controller.service;

import cn.bugstack.middleware.schedule.domain.DataCollect;
import cn.bugstack.middleware.schedule.domain.DcsScheduleInfo;
import cn.bugstack.middleware.schedule.domain.DcsServerNode;
import cn.bugstack.middleware.schedule.domain.Instruct;

import java.util.List;

/**
 * 博  客：http://bugstack.cn
 * 公众号：bugstack虫洞栈 | 沉淀、分享、成长，让自己和他人都能有所收获！
 * create by 付政委 on @2019
 */
public interface DcsScheduleService {

    List<String> queryPathRootServerList() throws Exception;

    List<DcsScheduleInfo> queryDcsScheduleInfoList(String schedulerServerId) throws Exception;

    void pushInstruct(Instruct instruct) throws Exception;

    DataCollect queryDataCollect() throws Exception;

    List<DcsServerNode> queryDcsServerNodeList() throws Exception;

}
