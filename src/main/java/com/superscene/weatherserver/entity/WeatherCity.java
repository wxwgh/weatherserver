package com.superscene.weatherserver.entity;


import lombok.Data;

@Data
public class WeatherCity {

  private String smid;
  private String smx;
  private String smy;
  private String smlibtileid;
  private String smuserid;
  private String id;
  private String name;
  private String district;
  private String province;
  private String nation;
  private String X;
  private String Y;
  private String city;
  private String grade;
  private String flag;
  private String imgUrl;
  private String weather;
  private String maxTemperature;
  private String minTemperature;
  private String rain;
  private String rainfall;
  private String windDirection;
  private String windSpeed;
  private String startTime;
  private String endTime;

}
