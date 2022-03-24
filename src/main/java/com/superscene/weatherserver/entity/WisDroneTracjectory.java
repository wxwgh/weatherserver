package com.superscene.weatherserver.entity;

import lombok.Data;

/**
 * 无人机轨迹
 */
@Data
public class WisDroneTracjectory {
    String id; //id
    String latitude; //经度
    String longtitude; //维度
    String height; //高度
    String createDate; //创建时间
}
