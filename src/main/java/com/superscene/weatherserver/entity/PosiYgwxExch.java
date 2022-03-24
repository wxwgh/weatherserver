package com.superscene.weatherserver.entity;

import lombok.Data;

/**
 * 卫星遥感
 */
@Data
public class PosiYgwxExch {
String   id; //id
String   longitude; //经度
String   latitude; //纬度
String   observationFrequency; //观测频次
String   observationDatetime; //观测时间
String   strength; //强度
String   strengthLevel; //强度等级
String   woodland; //林地占比
String   grassland; //草地占比
String   farmland; //农田占比
String   otherland; //其他占比
String   area; //面积（公顷）
String   credibility; //可信度
String   pixelarea; //像元面积
String   pixelNumber; //像元数
String   country; //国家
String   countryCode; //国家代码
String   province; //省
String   provinceCode; //省代码
String   city; //市
String   cityCode; //市代码
String   county; //区
String   countyCode; //区代码
String   formattedAddress; //地址
String   visibleLightImageAddress; //可见光图片地址
String   irimageAddress; //热成像图片地址
String   satellite; //卫星源
String   putstorageTime; //入库时间
String   rireno; //火警编号
String   bh; //编号
}
