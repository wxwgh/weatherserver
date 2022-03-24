package com.superscene.weatherserver.entity;

import lombok.Data;

/**
 * 火场标绘信息接收接口
 */
@Data
public class WisFirePlot {
    String id;
    String latitude; //边际点经度
    String longtitude; //边际点维度
    String createDate; //创建时间
    String fireClass; //火情级别
    String fireScope; //火情范围
    String fireInfo; //火情情况
    String fireStart; //火情开始时间
    String fireEnd; //火情结束时间
}
