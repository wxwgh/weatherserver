package com.superscene.weatherserver.mapper;

import com.superscene.weatherserver.entity.PosiYgwxExch;
import com.superscene.weatherserver.entity.UavRecord;
import com.superscene.weatherserver.entity.WisDroneTracjectory;
import com.superscene.weatherserver.entity.WisFirePlot;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * FirePortMapper 无人机火场
 * hb 20210615
 */
@Repository
public interface FirePortMapper {
    @Results(id = "all_FirePort", value = {
            @Result(column = "ID",property ="id"),
            @Result(column = "LATITUDE",property ="latitude"),
            @Result(column = "LONGTITUDE",property ="longtitude"),
            @Result(column = "CREATE_DATE",property ="createDate"),
            @Result(column = "FIRE_CLASS",property ="fireClass"),
            @Result(column = "FIRE_SCOPE",property ="fireScope"),
            @Result(column = "FIRE_INFO",property ="fireInfo"),
            @Result(column = "FIRE_START",property ="fireStart"),
            @Result(column = "FIRE_END",property ="fireEnd")})
    @Select("select * from T_WIS_FIRE_PLOT")
    List<WisFirePlot> getWisFirePlotList();

    @Results(id = "all_UavRecord", value = {
            @Result(column = "ID",property ="id"),
            @Result(column = "NAME",property ="name"),
            @Result(column = "FILE_SIZE",property ="filesize"),
            @Result(column = "PATH",property ="path"),
            @Result(column = "TYPE",property ="type"),
            @Result(column = "TIME",property ="time")})
    @Select("select * from T_UAV_RECORD t where time >= trunc(sysdate -3)")
    List<UavRecord> getUAVRecord() throws Exception;



    @ResultMap("all_UavRecord")
    @Select("select * from T_UAV_RECORD t where time " +
            "between to_date(#{starttm},'yyyy-mm-dd HH24:MI:SS') and to_date(#{endtm},'yyyy-mm-dd HH24:MI:SS')")
    List<UavRecord> getUAVRecordByTime(@Param("starttm") String starttm, @Param("endtm") String endtm);

}
