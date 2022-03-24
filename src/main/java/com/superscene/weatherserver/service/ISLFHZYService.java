package com.superscene.weatherserver.service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: ISLFHZYService
 * @Description: TODO
 * @AUTHOR:ZZQ
 * @DATE:2021/10/31 12:32
 **/
public interface ISLFHZYService {

    List<Map<String, Object>> getBZYDWInfo() throws Exception;

    List<Map<String, Object>> getFHZHBInfo() throws Exception;

    List<Map<String, Object>> getHLJCZInfo() throws Exception;

    List<Map<String, Object>> getJCZInfo() throws Exception;

    List<Map<String, Object>> getLWTInfo() throws Exception;

    List<Map<String, Object>> getPHDYFInfo() throws Exception;

    List<Map<String, Object>> getQXZInfo() throws Exception;

    List<Map<String, Object>> getSYDInfo() throws Exception;

    List<Map<String, Object>> getWZKInfo() throws Exception;

    List<Map<String, Object>> getZDWXInfo() throws Exception;

    List<Map<String, Object>> getZYDInfo() throws Exception;

}
