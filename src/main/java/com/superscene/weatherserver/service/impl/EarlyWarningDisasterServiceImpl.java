package com.superscene.weatherserver.service.impl;

import com.superscene.weatherserver.mapper.EarlyWarningDisasterMapper;
import com.superscene.weatherserver.service.IEarlyWarningDisasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: EarlyWarningDisasterServiceImpl
 * @Description: TODO
 * @AUTHOR:ZXY
 * @DATE:2020/7/28 14:25
 **/
@Service
public class EarlyWarningDisasterServiceImpl implements IEarlyWarningDisasterService {

    @Autowired
    private EarlyWarningDisasterMapper mapper;

    @Override
    public List<Map<String,Object>> getInfoListService() throws Exception{
        return mapper.queryInfoAll();
    }

    @Override
    public String getContent(String id) throws Exception {
        return mapper.queryContent(id);
    }

}
