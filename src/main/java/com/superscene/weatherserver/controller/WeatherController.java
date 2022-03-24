package com.superscene.weatherserver.controller;

import com.superscene.weatherserver.entity.Result;
import com.superscene.weatherserver.entity.WeatherForecast;
import com.superscene.weatherserver.service.IWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: WeatherController
 * @Description: 天气预报数据交互
 * @AUTHOR:ZXY
 * @DATE:2020/3/12 14:37
 **/
@ResponseBody
@Controller
public class WeatherController {

    @Autowired
    private IWeatherService iWeatherService;

    @RequestMapping("/getWeatherList")
    public Result getWeatherList(HttpServletRequest request, @RequestParam("grade") String grade) {
        List<Map<String, Object>> weatherList = new ArrayList<>();
        String code = "1";
        String inifo = "天气获取失败!";
        String debug = "";
        try {
            code = "0";
            inifo = "天气获取成功!";
            weatherList = iWeatherService.getWeatherList(grade);
        } catch (Exception e) {
            debug = e.getMessage();
        }
        return new Result(code, inifo, debug, request.getRequestURL().toString(), weatherList);
    }

    @RequestMapping("/getDetailedWeather")
    public Result getDetailedWeather(HttpServletRequest request, @RequestBody WeatherForecast params) {
        List<Map<String, Object>> weatherList = new ArrayList<>();
        String code = "1";
        String inifo = "天气详情失败!";
        String debug = "";
        try {
            code = "0";
            inifo = "天气获取成功!";
            weatherList = iWeatherService.getDetailedWeather(params.getName(), params.getDistrict(), params.getProvince());
        } catch (Exception e) {
            debug = e.getMessage();
        }
        return new Result(code, inifo, debug, request.getRequestURL().toString(), weatherList);
    }

}
