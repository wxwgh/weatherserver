package com.superscene.weatherserver.mapper;

import com.superscene.weatherserver.entity.PosiYgwxExch;
import com.superscene.weatherserver.entity.TWeatherDit;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface YgwxexchMapper {
    @Results(id = "all_ygwxexch", value = {
            @Result(column = "ID", property = "id"),
            @Result(column = "LONGITUDE", property = "longitude"),
            @Result(column = "LATITUDE", property = "latitude"),
            @Result(column = "OBSERVATIONFREQUENCY", property = "observationFrequency"),
            @Result(column = "OBSERVATIONDATETIME", property = "observationDatetime"),
            @Result(column = "STRENGTH", property = "strength"),
            @Result(column = "STRENGTHLEVEL", property = "strengthLevel"),
            @Result(column = "WOODLAND", property = "woodland"),
            @Result(column = "GRASSLAND", property = "grassland"),
            @Result(column = "FARMLAND", property = "farmland"),
            @Result(column = "OTHERLAND", property = "otherland"),
            @Result(column = "AREA", property = "area"),
            @Result(column = "CREDIBILITY", property = "credibility"),
            @Result(column = "PIXELAREA", property = "pixelarea"),
            @Result(column = "PIXELNUMBER", property = "pixelNumber"),
            @Result(column = "COUNTRY", property = "country"),
            @Result(column = "COUNTRYCODE", property = "countryCode"),
            @Result(column = "PROVINCE", property = "province"),
            @Result(column = "PROVINCECODE", property = "provinceCode"),
            @Result(column = "CITY", property = "city"),
            @Result(column = "CITYCODE", property = "cityCode"),
            @Result(column = "COUNTY", property = "county"),
            @Result(column = "COUNTYCODE", property = "countyCode"),
            @Result(column = "FORMATTEDADDRESS", property = "formattedAddress"),
            @Result(column = "VISIBLELIGHTIMAGEADDRESS", property = "visibleLightImageAddress"),
            @Result(column = "IRIMAGEADDRESS", property = "irimageAddress"),
            @Result(column = "SATELLITE", property = "satellite"),
            @Result(column = "PUTSTORAGETIME", property = "putstorageTime"),
            @Result(column = "RIRENO", property = "rireno"),
            @Result(column = "BH", property = "bh")
    })
    @Select("select * from T_POSI_YGWX_EXCH")
    List<PosiYgwxExch> getPosiYgwxExchList();

    @Select("SELECT * FROM T_POSI_YGWX_EXCH a where a.PUTSTORAGETIME = (SELECT MAX(b.PUTSTORAGETIME) FROM T_POSI_YGWX_EXCH b WHERE a.RIRENO=b.RIRENO) and translate(substr(a.PUTSTORAGETIME, 0, 19),'T',' ') > #{time}")
    List<PosiYgwxExch> getPosiYgwxExchListByTime(String time);

}
