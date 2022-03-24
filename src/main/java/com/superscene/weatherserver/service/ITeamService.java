package com.superscene.weatherserver.service;

import java.util.List;
import java.util.Map;

public interface ITeamService {

    List<Map<String, Object>> teamInfo(Integer type) throws Exception;

    List<Map<String, Object>> getDWDMInfo() throws Exception;

    List<Map<String, Object>> getRYSBInfo(String zd,String zhd,String dzd) throws Exception;
}
