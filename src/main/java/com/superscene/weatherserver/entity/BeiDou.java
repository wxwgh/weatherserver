package com.superscene.weatherserver.entity;

import lombok.Data;

import java.util.Date;

/**
 * 北斗海星
 *
 * @Author TanXj
 * @Date 2021/6/8
 */
@Data
public class BeiDou {

    private String ID;

    private String GPSID;

    private String XM;

    private String XZQHDM;

    private String XZQHMC;

    private String DWDM;

    private String ZWDM;

    private String PHONENUM;

    private Date POSITIME;

    private String LATITUDE;//经度

    private String LONGTITUDE;//经度

    private String SBLX;
}
