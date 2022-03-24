package com.superscene.weatherserver.mapper;

/**
 * 北斗Mapper
 *
 * @Author TanXj
 * @Date 2021/6/8
 */

import com.superscene.weatherserver.entity.BeiDou;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BeidouMapper {

    List<BeiDou> queryBySblx(@Param("sblx") String sblx);
    List<BeiDou> queryByToday(@Param("today") String today);
    List<BeiDou> queryTotalXT();
    List<BeiDou> queryXTByDWDM(@Param("dwdm")String dwdm);
    List<BeiDou> queryXTByTime(@Param("starttm")String starttm, @Param("endtm")String endtm);
    List<BeiDou> queryPath(@Param("gpsid")String gpsid, @Param("starttm")String starttm, @Param("endtm")String endtm);
    List<BeiDou> queryByNow(@Param("starttm")String starttm, @Param("endtm")String endtm);
    List<BeiDou> queryAllByToday(@Param("starttm")String starttm, @Param("endtm")String endtm);
    List<BeiDou> queryByOnline();
    List<BeiDou> queryByOutline();
}
