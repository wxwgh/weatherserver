package com.superscene.weatherserver.controller;

import com.superscene.weatherserver.entity.*;
import com.superscene.weatherserver.service.INewFunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @ClassName: NewFunctionController
 * @Description: 新增需求
 * @AUTHOR:ZXY
 * @DATE:2020/3/12 14:37
 **/
@ResponseBody
@Controller
public class NewFunctionController {
    INewFunctionService newFunctionService;

    @Autowired
    public NewFunctionController(INewFunctionService newFunctionService) {
        this.newFunctionService = newFunctionService;
    }
    @RequestMapping("/getFirePlotList")
    public Result getFirePlotList(HttpServletRequest request) {
        List<WisFirePlot> wisFirePlotList = new ArrayList<>();
        String code = "1";
        String inifo = "无人机火场获取失败!";
        String debug = "";
        try {
            code = "0";
            inifo = "无人机火场获取成功!";
            wisFirePlotList = newFunctionService.getWisFirePlots();
        } catch (Exception e) {
            debug = e.getMessage();
        }
        return new Result(code, inifo, debug, request.getRequestURL().toString(), wisFirePlotList);
    }
    @CrossOrigin
    @RequestMapping("/getYgwxexchList/{type}")
    public Result getWeatherList(HttpServletRequest request,@PathVariable String type) {
        List<PosiYgwxExch> posiYgwxExchList = new ArrayList<>();
        String code = "1";
        String inifo = "卫星遥感获取失败!";
        String debug = "";
        try {
            code = "0";
            inifo = "卫星遥感获取成功!";
            Date date = new Date();
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Calendar rightNow = Calendar.getInstance();
            rightNow.setTime(date);

            if(type.equals("1"))//1小时内
            {
                rightNow.add(Calendar.HOUR, -1);
            }
            if(type.equals("2"))//3小时内
            {
                rightNow.add(Calendar.HOUR, -3);
            }
            if(type.equals("3"))//1天内
            {
                rightNow.add(Calendar.DATE, -1);
            }
            if(type.equals("4"))//3天内
            {
                rightNow.add(Calendar.DATE, -3);
            }
            if(type.equals("5"))//5天内
            {
                rightNow.add(Calendar.DATE, -5);
            }
            String timestring = sdf.format(rightNow.getTime());
            posiYgwxExchList = newFunctionService.getPosiYgwxExchesByTime(timestring);
        } catch (Exception e) {
            debug = e.getMessage();
        }
        return new Result(code, inifo, debug, request.getRequestURL().toString(), posiYgwxExchList);
    }
    @RequestMapping("/getDroneTracjectoryList")
    public Result getDroneTracjectoryList(HttpServletRequest request) {
        List<WisDroneTracjectory> wisDroneTracjectoryList = new ArrayList<>();
        String code = "1";
        String inifo = "无人机轨迹获取失败!";
        String debug = "";
        try {
            code = "0";
            inifo = "无人机轨迹获取成功!";
            wisDroneTracjectoryList = newFunctionService.getWisDroneTracjectories();
        } catch (Exception e) {
            debug = e.getMessage();
        }
        return new Result(code, inifo, debug, request.getRequestURL().toString(), wisDroneTracjectoryList);
    }
    @RequestMapping("/getDronePointList")
    public Result getDronePointList(HttpServletRequest request) {
        List<WisDroneTracjectory> wisDroneTracjectoryList = new ArrayList<>();
        String code = "1";
        String inifo = "无人机轨迹获取失败!";
        String debug = "";
        try {
            code = "0";
            inifo = "无人机轨迹获取成功!";
            wisDroneTracjectoryList = newFunctionService.getNewPosition();
        } catch (Exception e) {
            debug = e.getMessage();
        }
        return new Result(code, inifo, debug, request.getRequestURL().toString(), wisDroneTracjectoryList);
    }
    @RequestMapping("/getDroneTrace")
    public Result getDroneTrace(HttpServletRequest request,@RequestBody FKPT fkpt) {
        String starttm= fkpt.starttm;
        String endtm= fkpt.endtm;
        starttm = starttm.substring(0,starttm.length()-4);
        endtm = endtm.substring(0,endtm.length()-4);
        List<WisDroneTracjectory> wisDroneTracjectoryList = new ArrayList<>();
        String code = "1";
        String inifo = "无人机轨迹获取失败!";
        String debug = "";
        try {
            code = "0";
            inifo = "无人机轨迹获取成功!";
            wisDroneTracjectoryList = newFunctionService.getDroneTrace(starttm,endtm);
        } catch (Exception e) {
            debug = e.getMessage();
        }
        return new Result(code, inifo, debug, request.getRequestURL().toString(), wisDroneTracjectoryList);
    }


    @RequestMapping(value = {"/uavrecord"},method = {RequestMethod.GET})
    public  Result getUavRecord(HttpServletRequest request){
        List<UavRecord> restList = new ArrayList<>();
        String code = "1";
        String inifo = "错误!";
        String debug = "";
        try {
            code = "0";
            inifo = "成功!";
            restList = newFunctionService.getUAVRecord();
        } catch (Exception e) {
            debug = e.getMessage();
        }
        return new Result(code, inifo, debug, request.getRequestURL().toString(), restList);
    }

    @RequestMapping(value = {"/uavrecord"},method = {RequestMethod.POST})
    public  Result getUavRecordByTime(HttpServletRequest request,@RequestBody FKPT fkpt){
        String starttm= fkpt.starttm;
        String endtm= fkpt.endtm;
        starttm = starttm.substring(0,starttm.length()-4);
        endtm = endtm.substring(0,endtm.length()-4);
        List<UavRecord> restList = new ArrayList<>();
        String code = "1";
        String inifo = "错误!";
        String debug = "";
        try {
            code = "0";
            inifo = "成功!";
            restList = newFunctionService.getUAVRecordByTime(starttm,endtm);
        } catch (Exception e) {
            debug = e.getMessage();
        }
        return new Result(code, inifo, debug, request.getRequestURL().toString(), restList);
    }
}
