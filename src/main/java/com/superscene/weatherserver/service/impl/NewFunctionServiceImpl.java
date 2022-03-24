package com.superscene.weatherserver.service.impl;

import com.superscene.weatherserver.entity.PosiYgwxExch;
import com.superscene.weatherserver.entity.UavRecord;
import com.superscene.weatherserver.entity.WisDroneTracjectory;
import com.superscene.weatherserver.entity.WisFirePlot;
import com.superscene.weatherserver.mapper.DroneTraceMapper;
import com.superscene.weatherserver.mapper.FirePortMapper;
import com.superscene.weatherserver.mapper.YgwxexchMapper;
import com.superscene.weatherserver.service.INewFunctionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class NewFunctionServiceImpl implements INewFunctionService {
    private DroneTraceMapper droneTraceMapper;
    private FirePortMapper firePortMapper;
    private YgwxexchMapper ygwxexchMapper;
    @Autowired
    public void setDroneTraceMapper(DroneTraceMapper droneTraceMapper) {
        this.droneTraceMapper = droneTraceMapper;
    }
    @Autowired
    public void setFirePortMapper(FirePortMapper firePortMapper) {
        this.firePortMapper = firePortMapper;
    }
    @Autowired
    public void setYgwxexchMapper(YgwxexchMapper ygwxexchMapper) {
        this.ygwxexchMapper = ygwxexchMapper;
    }

    @Override
    public List<WisFirePlot> getWisFirePlots() {
        return firePortMapper.getWisFirePlotList();
    }

    @Override
    public List<PosiYgwxExch> getPosiYgwxExches() {
        return ygwxexchMapper.getPosiYgwxExchList();
    }

    @Override
    public List<PosiYgwxExch> getPosiYgwxExchesByTime(String time) {
        return ygwxexchMapper.getPosiYgwxExchListByTime(time);
    }

    @Override
    public List<WisDroneTracjectory> getWisDroneTracjectories() {
        return droneTraceMapper.getWisDroneTracjectoryList();
    }

    @Override
    public List<WisDroneTracjectory> getNewPosition() {
        return droneTraceMapper.getNewPositon();
    }

    @Override
    public List<UavRecord> getUAVRecord() throws Exception {
        return firePortMapper.getUAVRecord();
    }

    @Override
    public List<UavRecord> getUAVRecordByTime(String starttm, String endtm) throws Exception {
        return firePortMapper.getUAVRecordByTime(starttm,endtm);
    }

    @Override
    public List<WisDroneTracjectory> getDroneTrace(String starttm, String endtm) {
        return droneTraceMapper.getDroneTrace(starttm,endtm);
    }
}
