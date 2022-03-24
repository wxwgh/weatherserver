package com.superscene.weatherserver.task;

import com.superscene.weatherserver.service.IWeatherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @ClassName: WeatherDataUpdate
 * @Description: 天气数据定时更新
 * @AUTHOR:ZXY
 * @DATE:2020/3/8 11:43
 **/
@Slf4j
@Component
public class WeatherDataUpdate {

    @Autowired
    private IWeatherService iWeatherService;

    @Scheduled(cron = "0 0 9,21 * * ?") // 每天上午9点和下午21点各执行一次
    public void update() {
        log.info("startUpdateWeatherData");
        iWeatherService.updateWeatherData();
        log.info("endUpdateWeatherData");
        iWeatherService.deleteWeatherData();
        iWeatherService.insertWeatherData();
    }


}
