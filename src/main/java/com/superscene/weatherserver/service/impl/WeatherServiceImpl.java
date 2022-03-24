package com.superscene.weatherserver.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.superscene.weatherserver.config.Constants;
import com.superscene.weatherserver.entity.TWeatherDit;
import com.superscene.weatherserver.entity.WeatherCity;
import com.superscene.weatherserver.entity.WeatherForecast;
import com.superscene.weatherserver.mapper.WeatherMapper;
import com.superscene.weatherserver.service.IWeatherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @ClassName: WeatherServiceImpl
 * @Description: TODO
 * @AUTHOR:ZXY
 * @DATE:2020/3/8 13:14
 **/
@Slf4j
@Service
public class WeatherServiceImpl implements IWeatherService {

    @Autowired
    private WeatherMapper weatherMapper;
    @Autowired
    private RestTemplate restTemplate;

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");

    @Override
    public void updateWeatherData() {
        List<WeatherCity> forecastInfo = getForecastInfo();
        if (forecastInfo.size()>0){
            weatherMapper.updateWeatherCity(forecastInfo);
        }

    }

    @Override
    public void insertWeatherData() {
        List<WeatherCity> forecastInfo = getAllForecastInfo();
        System.out.println(forecastInfo.size());
        for (WeatherCity weatherCity:forecastInfo) {
            weatherMapper.insertWeatherCity(weatherCity);
        }

    }

    @Override
    public void deleteWeatherData() {
        weatherMapper.deleteWeatherCity();
    }

    @Override
    public List<Map<String, Object>> getWeatherList(String grade) throws Exception {
        return weatherMapper.queryWeatherAll(grade);
    }

    @Override
    public List<Map<String, Object>> getDetailedWeather(String name, String district, String province) throws Exception {
        return weatherMapper.queryCityWeatherByNameAndDistrictAndProvince(name,district,province);
    }

    /**
     * 获取forecast数组里面的数据拿当前时间区间的一条，加上归属省、归属地、地名三个条件组装，批量update
     * @return
     */
    public List<WeatherCity> getForecastInfo() {
        List<TWeatherDit> tWeatherDits = weatherMapper.queryTWeatherDitList();
        Map<String, Object> tWeatherDitsMap = new HashMap<>();
        for (int i = 0; i < tWeatherDits.size(); i++) {
            tWeatherDitsMap.put(tWeatherDits.get(i).getName(),tWeatherDits.get(i).getValue());
        }
        String url = Constants.CITY_WEAther_FORECAST;
        List<WeatherCity> weatherCityList = new ArrayList<>();
        try {
            JSONArray objects = restTemplate.getForObject(url, JSONArray.class);
            for (int i = 0; i < objects.size(); i++) {
                WeatherForecast object = objects.getObject(i, WeatherForecast.class);
                List<List<String>> forecast = object.getForecast();
                for (int j = 0; j < forecast.size(); j++) {
                    List<String> strs = forecast.get(j);
                    String start = strs.get(strs.size() - 1);
                    long startTime = dateFormat.parse(start).getTime();
                    String end = strs.get(strs.size() - 2);
                    long endTime = dateFormat.parse(end).getTime();
                    long thisTime = new Date().getTime();
                    if (startTime > thisTime && thisTime > endTime){
                        //当前时间区间的天气情况
                        WeatherCity weatherCity = new WeatherCity();
                        weatherCity.setProvince(object.getProvince());
                        weatherCity.setDistrict(object.getDistrict());
                        weatherCity.setName(object.getName());
                        weatherCity.setWeather(strs.get(0));
                        weatherCity.setMaxTemperature(strs.get(1));
                        weatherCity.setMinTemperature(strs.get(2));
                        weatherCity.setRain(strs.get(3));
                        weatherCity.setRainfall(strs.get(4));
                        weatherCity.setWindDirection(strs.get(5));
                        weatherCity.setWindSpeed(strs.get(6));
                        weatherCity.setImgUrl(tWeatherDitsMap.get(strs.get(0)).toString());
                        weatherCityList.add(weatherCity);
                    }
                }
            }
        } catch (Exception e) {
//            log.error(e.getMessage());
        }
        return weatherCityList;
    }


    /**
     * 获取所有地区的forecast天气预报
     * @return
     */
    public List<WeatherCity> getAllForecastInfo() {
        String url = Constants.CITY_WEAther_FORECAST;
        List<WeatherCity> weatherCityList = new ArrayList<>();
        try {
            JSONArray objects = restTemplate.getForObject(url, JSONArray.class);
            for (int i = 0; i < objects.size(); i++) {
                WeatherForecast object = objects.getObject(i, WeatherForecast.class);
                List<List<String>> forecast = object.getForecast();
                for (int j = 0; j < forecast.size(); j++) {
                    List<String> strs = forecast.get(j);
                    WeatherCity weatherCity = new WeatherCity();
                    weatherCity.setProvince(object.getProvince());
                    weatherCity.setDistrict(object.getDistrict());
                    weatherCity.setName(object.getName());
                    weatherCity.setWeather(strs.get(0));
                    weatherCity.setStartTime(strs.get(strs.size() - 2));
                    weatherCity.setEndTime(strs.get(strs.size() - 1));
                    weatherCity.setMaxTemperature(strs.get(1));
                    weatherCity.setMinTemperature(strs.get(2));
                    weatherCity.setRain(strs.get(3));
                    weatherCity.setRainfall(strs.get(4));
                    weatherCity.setWindDirection(strs.get(5));
                    weatherCity.setWindSpeed(strs.get(6));
                    weatherCityList.add(weatherCity);

                }
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return weatherCityList;
    }

}
