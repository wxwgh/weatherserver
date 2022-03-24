package com.superscene.weatherserver.service;

import com.superscene.weatherserver.entity.MessageDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author wxw
 * @Date 2022/2/28
 */
public interface MessageService {

    // 获取全部报文
    List<MessageDao> queryByToday(String starttm, String endtm);

    //根据时间区间获取报文
    List<MessageDao> queryByTime(String starttm, String endtm);
}
