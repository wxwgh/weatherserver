package com.superscene.weatherserver.filter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class InternalMemHolder {

    public static Map<String,String> map = new ConcurrentHashMap<>();

    public static Map<String, String> getMap() {
        return map;
    }

    public static void setMap(Map<String, String> map) {
        InternalMemHolder.map = map;
    }
}
