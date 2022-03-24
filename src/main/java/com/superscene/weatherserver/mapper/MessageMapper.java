package com.superscene.weatherserver.mapper;

/**
 * 通信报文Mapper
 *
 * @Author wxw
 * @Date 2022/2/28
 */

import com.superscene.weatherserver.entity.MessageDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageMapper {

    //全部查询
    List<MessageDao> queryByToday(@Param("starttm")String starttm, @Param("endtm")String endtm);
    //根据时间区间查询
    List<MessageDao> queryByTime(@Param("starttm")String starttm, @Param("endtm")String endtm);
}
