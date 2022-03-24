package com.superscene.weatherserver.entity;

import java.util.Date;
import lombok.Data;

/*
*
* 通信电文
* @Author wxw
* @Date 2022/2/28
*
* */

@Data
public class MessageDao {

    public String ID; //唯一标识
    public String INFORMATION; //信息类型
    public String USERADDRESS; //用户地址 ID
    public String MESSAGEFORM; //电文形式
    public String SENDINGTIME; //发信时间
    public Date JLRKSJ;//入库时间
    public String MESSAGE; //通信电文内容
    public String DW; //单位名称

}
