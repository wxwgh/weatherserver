package com.superscene.weatherserver.controller;

import com.alibaba.fastjson.JSON;
import com.superscene.weatherserver.entity.Result;
import com.superscene.weatherserver.service.ITeamService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: TeamController
 * @Description: 队伍人员信息
 * @AUTHOR:ZXY
 * @DATE:2020/4/15 12:47
 **/
@Slf4j
@RestController
public class TeamController {

    @Autowired
    private ITeamService iTeamService;

    @RequestMapping(value = {"/findTeamInfo"})
    public  Result findTeamInfo(HttpServletRequest request,@RequestParam String type){
        List<Map<String, Object>> restList = new ArrayList<>();
        String code = "1";
        String inifo = "错误!";
        String debug = "";
        try {
            code = "0";
            inifo = "成功!";
            restList = iTeamService.teamInfo(Integer.valueOf(type));
        } catch (Exception e) {
            debug = e.getMessage();
        }
        return new Result(code, inifo, debug, request.getRequestURL().toString(), restList);
    }

    @RequestMapping(value = {"/findDWDMInfo"},method = {RequestMethod.GET})
    public  Result findDWDMInfo(HttpServletRequest request){
        List<Map<String, Object>> restList = new ArrayList<>();
        String code = "1";
        String inifo = "错误!";
        String debug = "";
        try {
            code = "0";
            inifo = "成功!";
            restList = iTeamService.getDWDMInfo();
        } catch (Exception e) {
            debug = e.getMessage();
        }
        return new Result(code, inifo, debug, request.getRequestURL().toString(), restList);
    }

    @RequestMapping(value = {"/findRYSBInfo"})
    public  Result findRYSBInfo(HttpServletRequest request, @RequestParam String zd,@RequestParam String zhd,@RequestParam String dzd){
        List<Map<String, Object>> restList = new ArrayList<>();
        String code = "1";
        String inifo = "错误!";
        String debug = "";
        try {
            code = "0";
            inifo = "成功!";
            restList = iTeamService.getRYSBInfo(zd,zhd,dzd);
        } catch (Exception e) {
            debug = e.getMessage();
        }
        return new Result(code, inifo, debug, request.getRequestURL().toString(), restList);
    }

}
