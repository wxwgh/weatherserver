package com.superscene.weatherserver.mapper;

import com.superscene.weatherserver.entity.PosiYgwxExch;
import com.superscene.weatherserver.entity.WisDroneTracjectory;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DroneTraceMapper {
    @Results(id = "all_DroneTrace", value = {
            @Result(column = "ID",property ="id"),
            @Result(column = "LATITUDE",property ="latitude"),
            @Result(column = "LONGTITUDE",property ="longtitude"),
            @Result(column = "HEIGHT",property ="height"),
            @Result(column = "CREATE_DATE",property ="createDate")
    })
    @Select("select * from T_WIS_DRONETRAJECTORY")
    List<WisDroneTracjectory> getWisDroneTracjectoryList();

    @Select("select * from T_WIS_DRONETRAJECTORY where to_date(CREATE_DATE,'yyyymmddHH24MISS')=(select max(to_date(CREATE_DATE,'yyyymmddHH24MISS')) from T_WIS_DRONETRAJECTORY)")
    @ResultMap("all_DroneTrace")
    List<WisDroneTracjectory> getNewPositon();

    @Select("select * from T_WIS_DRONETRAJECTORY where to_date(CREATE_DATE,'yyyy-mm-dd HH24:MI:SS') " +
            "between to_date(#{starttm},'yyyy-mm-dd HH24:MI:SS') and to_date(#{endtm},'yyyy-mm-dd HH24:MI:SS')")
    @ResultMap("all_DroneTrace")
    List<WisDroneTracjectory> getDroneTrace(@Param("starttm") String starttm,@Param("endtm") String endtm);









}
