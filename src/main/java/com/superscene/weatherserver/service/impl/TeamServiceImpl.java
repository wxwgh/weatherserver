package com.superscene.weatherserver.service.impl;

import com.superscene.weatherserver.mapper.TeamServiceMapper;
import com.superscene.weatherserver.service.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: TeamServiceImpl
 * @Description: TODO
 * @AUTHOR:ZXY
 * @DATE:2020/4/15 14:21
 **/
@Service
public class TeamServiceImpl implements ITeamService {

    @Autowired
    TeamServiceMapper teamServiceMapper;

    @Override
    public List<Map<String, Object>> teamInfo(Integer type)throws Exception{
        List<Map<String, Object>> result = new ArrayList<>();
        switch (type){
            case 0:
                //大中队
                result = teamServiceMapper.getDZDInfo();
                break;
            case 1:
                //支队
                result = teamServiceMapper.getZHDInfo();
                break;
            case 2:
                //总队
                result = teamServiceMapper.getZDInfo();
                break;
        }
        return result;
    }

    @Override
    public List<Map<String, Object>> getDWDMInfo() throws Exception {
        return teamServiceMapper.getDWDMInfo();
    }

    @Override
    public List<Map<String, Object>> getRYSBInfo(String zd,String zhd,String dzd) throws Exception {
        List<Map<String, Object>> result = new ArrayList<>();
        if (zd!="" && zhd == "" && dzd==""){
            result = teamServiceMapper.getRYZBZDInfo(zd);
        }
        else if (zd!="" && zhd  != "" && dzd ==""){
            result = teamServiceMapper.getRYZBZHDInfo(zd,zhd);
        }
        else if (zd!="" && zhd  != "" && dzd !=""){
            result = teamServiceMapper.getRYZBDZDInfo(zd, zhd, dzd);
        }
        return result;
    }
}
