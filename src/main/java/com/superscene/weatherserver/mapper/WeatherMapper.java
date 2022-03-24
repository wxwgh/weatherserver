package com.superscene.weatherserver.mapper;

import com.superscene.weatherserver.entity.TWeatherDit;
import com.superscene.weatherserver.entity.WeatherCity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: WeatherMapper
 * @Description: TODO
 * @AUTHOR:ZXY
 * @DATE:2020/3/8 13:12
 **/
@Repository
public interface WeatherMapper {

    @Select("select t.id,t.name,t.value from T_WEATHER_DIT t")
    List<TWeatherDit> queryTWeatherDitList();

    int updateWeatherCity(@Param("weatherCityList") List<WeatherCity> weatherCityList);

    //  int insertWeatherCity(@Param("weatherCityList") List<WeatherCity>  weatherCityList);

    int insertWeatherCity(@Param("weatherCity") WeatherCity weatherCity);

    int deleteWeatherCity();

    @Select("select t.name,t.district,t.province,t.img_url,t.x,t.y from P_CITY_3857 t where t.grade =#{grade}")
    List<Map<String, Object>> queryWeatherAll(@Param("grade") String grade) throws Exception;

    @Select("select name, \n" +
            "district, \n" +
            "province, \n" +
            "nation, \n" +
            "weather, \n" +
            "max_temperature, \n" +
            "min_temperature, \n" +
            "rain, \n" +
            "rainfall, \n" +
            "wind_direction, \n" +
            "wind_speed, \n" +
            "to_date(t.start_time,'yyyy-mm-dd hh24:mi:ss') as start_time, \n" +
            "to_date(t.end_time,'yyyy-mm-dd hh24:mi:ss') as end_time from T_CITY_WEATHER t where t.name = #{name} and t.district = #{district} and t.province = #{province} order by t.start_time")
    List<Map<String, Object>> queryCityWeatherByNameAndDistrictAndProvince(@Param("name") String name, @Param("district") String district, @Param("province") String province) throws Exception;
}
