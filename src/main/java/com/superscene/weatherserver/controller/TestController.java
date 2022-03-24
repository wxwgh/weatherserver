package com.superscene.weatherserver.controller;

import com.superscene.weatherserver.service.IEarlyWarningDisasterService;
import com.superscene.weatherserver.service.IWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: TestController
 * @Description: TODO
 * @AUTHOR:ZXY
 * @DATE:2020/3/8 15:03
 **/
@Controller
public class TestController {

    @Autowired
    private IWeatherService iWeatherService;

    @Autowired
    private IEarlyWarningDisasterService iEarlyWarningDisasterService;

    @RequestMapping({"/test"})
    @ResponseBody
    public String test(){
        System.out.println(111111);

        try {
            long startTime = 0,endTime = 0;
            startTime = System.currentTimeMillis();
            System.out.println("start-Time:"+startTime);
            List<Map<String,Object>> list = iEarlyWarningDisasterService.getInfoListService();
            System.out.println(list);
            endTime = System.currentTimeMillis();
            System.out.println("start-Time:"+endTime);
            System.out.println("count-Time:"+(endTime-startTime));
            return "来了来了";
        } catch (Exception e) {
            e.printStackTrace();
        }
        //iWeatherService.updateWeatherData();
//        iWeatherService.deleteWeatherData();
//        iWeatherService.insertWeatherData();
        return null;
    }
}
