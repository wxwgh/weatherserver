package com.superscene.weatherserver.service;

import java.util.List;
import java.util.Map;

public interface IWeatherService {

    void updateWeatherData();

    void insertWeatherData();

    void deleteWeatherData();

    List<Map<String, Object>> getWeatherList(String grade) throws Exception;

    List<Map<String, Object>> getDetailedWeather(String name, String district, String province) throws Exception;
}
