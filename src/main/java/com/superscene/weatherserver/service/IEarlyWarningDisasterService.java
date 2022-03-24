package com.superscene.weatherserver.service;


import java.util.List;
import java.util.Map;

/**
 * @ClassName: IEarlyWarningDisasterService
 * @Description: TODO
 * @AUTHOR:ZXY
 * @DATE:2020/7/28 14:24
 **/
public interface IEarlyWarningDisasterService {

    List<Map<String,Object>> getInfoListService() throws Exception;

    String getContent(String id) throws  Exception;
}
