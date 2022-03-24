package com.superscene.weatherserver.controller;

import com.superscene.weatherserver.entity.Result;
import com.superscene.weatherserver.entity.Warning;
import com.superscene.weatherserver.service.IEarlyWarningDisasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: EarlyWarningDisasterController
 * @Description: 全国气象灾害预警
 * @AUTHOR:ZXY
 * @DATE:2020/7/28 14:03
 **/
@RestController
public class EarlyWarningDisasterController {

    @Autowired
    private IEarlyWarningDisasterService iEarlyWarningDisasterService;

    @CrossOrigin
    @RequestMapping(value = {"/findEarlyWarningDisasterInfoList"})
    public Result getInfoList(HttpServletRequest request){
        List<Map<String,Object>> list = new ArrayList<>();
        String code = "1";
        String inifo = "获取失败!";
        String debug = "";
        try {
            code = "0";
            inifo = "获取成功!";
            list = iEarlyWarningDisasterService.getInfoListService();
        } catch (Exception e) {
            debug = e.getMessage();
        }
        return new Result(code, inifo, debug, request.getRequestURL().toString(), list);

    }

    @RequestMapping(value = {"/findEarlyWarningDisasterContent"})
    public Result getContent(HttpServletRequest request, @RequestParam("id") String id){
        String str = "";
        String code = "1";
        String inifo = "获取失败!";
        String debug = "";
        try {
            code = "0";
            inifo = "获取成功!";
            str = iEarlyWarningDisasterService.getContent(id);
        } catch (Exception e) {
            debug = e.getMessage();
        }
        return new Result(code, inifo, debug, request.getRequestURL().toString(), str);

    }
}
