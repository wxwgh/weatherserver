package com.superscene.weatherserver.service.impl;

import com.superscene.weatherserver.entity.MessageDao;
import com.superscene.weatherserver.mapper.MessageMapper;
import com.superscene.weatherserver.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @Author wxw
 * @Date 2022/2/28
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageMapper messageMapper;


    @Override
    public List<MessageDao> queryByToday(String starttm, String endtm) {
        List<MessageDao> messageDao = messageMapper.queryByToday(starttm,endtm);
        return messageDao;
    }

    @Override
    public List<MessageDao> queryByTime(String starttm, String endtm) {
        List<MessageDao> messageDao = messageMapper.queryByTime(starttm,endtm);
        return messageDao;
    }
}
