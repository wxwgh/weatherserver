package com.superscene.weatherserver.entity;

import lombok.Data;

import java.util.List;

/**
 * @ClassName: WeatherForecast
 * @Description: TODO
 * @AUTHOR:ZXY
 * @DATE:2020/3/8 14:58
 **/
@Data
public class WeatherForecast {
    private String province;//归属省
    private String district;//归属地
    private String name;//地名
    private List<List<String>> forecast;//天气预报信息


}
