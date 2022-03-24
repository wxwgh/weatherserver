package com.superscene.weatherserver.service.impl;

import com.superscene.weatherserver.mapper.SLFHZYServiceMapper;
import com.superscene.weatherserver.service.ISLFHZYService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: SLFHZYServiceImpl
 * @Description: TODO
 * @AUTHOR:ZZQ
 * @DATE:2021/10/31 12:32
 **/
@Service
public class SLFHZYServiceImpl implements ISLFHZYService {

    @Autowired
    SLFHZYServiceMapper slfhzyServiceMapper;

    @Override
    public List<Map<String, Object>> getBZYDWInfo() throws Exception {
        return slfhzyServiceMapper.getBZYDWInfo();
    }

    @Override
    public List<Map<String, Object>> getFHZHBInfo() throws Exception {
        return slfhzyServiceMapper.getFHZHBInfo();
    }

    @Override
    public List<Map<String, Object>> getHLJCZInfo() throws Exception {
        return slfhzyServiceMapper.getHLJCZInfo();
    }

    @Override
    public List<Map<String, Object>> getJCZInfo() throws Exception {
        return slfhzyServiceMapper.getJCZInfo();
    }

    @Override
    public List<Map<String, Object>> getLWTInfo() throws Exception {
        return slfhzyServiceMapper.getLWTInfo();
    }

    @Override
    public List<Map<String, Object>> getPHDYFInfo() throws Exception {
        return slfhzyServiceMapper.getPHDYFInfo();
    }

    @Override
    public List<Map<String, Object>> getQXZInfo() throws Exception {
        return slfhzyServiceMapper.getQXZInfo();
    }

    @Override
    public List<Map<String, Object>> getSYDInfo() throws Exception {
        return slfhzyServiceMapper.getSYDInfo();
    }

    @Override
    public List<Map<String, Object>> getWZKInfo() throws Exception {
        return slfhzyServiceMapper.getWZKInfo();
    }

    @Override
    public List<Map<String, Object>> getZDWXInfo() throws Exception {
        return slfhzyServiceMapper.getZDWXInfo();
    }

    @Override
    public List<Map<String, Object>> getZYDInfo() throws Exception {
        return slfhzyServiceMapper.getZYDInfo();
    }
}
