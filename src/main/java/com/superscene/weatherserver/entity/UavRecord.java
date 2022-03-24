package com.superscene.weatherserver.entity;

import lombok.Data;

import java.util.Date;

/**
 * 无人机轨迹
 */
@Data
public class UavRecord {
    String id;
    String name;
    String filesize;
    String path;
    String type;
    Date time;
}
