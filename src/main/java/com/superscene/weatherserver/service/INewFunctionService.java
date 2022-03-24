package com.superscene.weatherserver.service;

import com.superscene.weatherserver.entity.PosiYgwxExch;
import com.superscene.weatherserver.entity.UavRecord;
import com.superscene.weatherserver.entity.WisDroneTracjectory;
import com.superscene.weatherserver.entity.WisFirePlot;

import java.util.List;
import java.util.Map;

public interface INewFunctionService {
    List<WisFirePlot> getWisFirePlots();
    List<PosiYgwxExch> getPosiYgwxExches();
    List<PosiYgwxExch> getPosiYgwxExchesByTime(String time);
    List<WisDroneTracjectory> getWisDroneTracjectories();
    List<WisDroneTracjectory> getDroneTrace(String starttm, String endtm);
    List<WisDroneTracjectory> getNewPosition();
    List<UavRecord> getUAVRecord() throws Exception;

    List<UavRecord> getUAVRecordByTime(String starttm, String endtm) throws Exception;
}
