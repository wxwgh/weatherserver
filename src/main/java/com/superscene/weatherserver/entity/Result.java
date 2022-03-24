package com.superscene.weatherserver.entity;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: Result
 * @Description: 消息响应体
 * @AUTHOR:ZXY
 * @DATE:2020/3/12 15:08
 **/
@Data
public class Result {
    private String code;//返回编号，成功："0",失败："-1"
    private String info;//操作信息，一般均会返回
    private String debug;//错误信息，后台报错时返回，方便调试
    private String url;//请求的url地址，如果是http请求会记录，方便调试
    private Object data;//结果数据

    public Result(String code, String info, String debug, String url, Object data) {
        this.code = code;
        this.info = info;
        this.debug = debug;
        this.url = url;
        this.data = data;
    }
}