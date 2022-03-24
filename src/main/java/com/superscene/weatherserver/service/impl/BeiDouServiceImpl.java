package com.superscene.weatherserver.service.impl;

import com.superscene.weatherserver.entity.BeiDou;
import com.superscene.weatherserver.mapper.BeidouMapper;
import com.superscene.weatherserver.service.IBeiDouService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author TanXj
 * @Date 2021/6/8
 */
@Service
public class BeiDouServiceImpl implements IBeiDouService {

    @Autowired
    private BeidouMapper beidouMapper;

    @Override
    public List<BeiDou> findBySblx(String sblx) {
        return beidouMapper.queryBySblx(sblx);
    }
    @Override
    public List<BeiDou> findByTody() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        String date=df.format(new Date());
        return beidouMapper.queryByToday("2021-06-06");
//        return beidouMapper.queryByToday(date);
    }

    @Override
    public List<BeiDou> queryTotalXT() {
        return beidouMapper.queryTotalXT();
    }

    @Override
    public List<BeiDou> queryXTByDWDM(String dwdm) {
        return beidouMapper.queryXTByDWDM(dwdm);
    }

    @Override
    public List<BeiDou> queryXTByTime(String starttm, String endtm) {
        return beidouMapper.queryXTByTime(starttm,endtm);
    }

    @Override
    public List<BeiDou> findByPath(String gpsid, String starttm, String endtm) {
        return beidouMapper.queryPath(gpsid,starttm,endtm);
    }

    @Override
    public List<BeiDou> queryByNow(String starttm, String endtm) {
        return beidouMapper.queryByNow(starttm,endtm);
    }

    @Override
    public List<BeiDou> queryAllByToday(String starttm, String endtm) {
        return beidouMapper.queryAllByToday(starttm,endtm);
    }

    @Override
    public List<BeiDou> queryByOnline() {
        return beidouMapper.queryByOnline();
    }

    @Override
    public List<BeiDou> queryByOutline() {
        return beidouMapper.queryByOutline();
    }
}
