package com.superscene.weatherserver.mapper;


import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: EarlyWarningDisasterMapper
 * @Description: TODO
 * @AUTHOR:ZXY
 * @DATE:2020/7/28 14:27
 **/
@Repository
public interface EarlyWarningDisasterMapper {

    List<Map<String,Object>> queryInfoAll() throws Exception;

    String queryContent(String id) throws Exception;
}
