package com.superscene.weatherserver.service;

import com.superscene.weatherserver.entity.BeiDou;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author TanXj
 * @Date 2021/6/8
 */
public interface IBeiDouService {

    List<BeiDou> findBySblx(@Param("sblx") String sblx);
    List<BeiDou> findByTody();
    List<BeiDou> queryTotalXT();
    List<BeiDou> queryXTByDWDM(String dwdm);
    List<BeiDou> queryXTByTime(String starttm, String endtm);
    List<BeiDou> findByPath(String gpsid, String starttm, String endtm);
    //获取当前在线设备
    List<BeiDou> queryByNow(String starttm, String endtm);
    //获取当天全部短报文
    List<BeiDou> queryAllByToday(String starttm, String endtm);
    //获取在线设备
    List<BeiDou> queryByOnline();
    //获取离线设备
    List<BeiDou> queryByOutline();
}
