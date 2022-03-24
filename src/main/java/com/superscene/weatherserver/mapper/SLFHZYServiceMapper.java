package com.superscene.weatherserver.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: SLFHZYServiceMapper
 * @Description: TODO
 * @AUTHOR:ZZQ
 * @DATE:2021/10/31 12:32
 **/
@Repository
public interface SLFHZYServiceMapper {

    @Select("select * from T_SLXF_BZYDW t")
    List<Map<String,Object>> getBZYDWInfo() throws Exception;

    @Select("select * from T_SLXF_FHZHB t")
    List<Map<String,Object>> getFHZHBInfo() throws Exception;

    @Select("select * from T_SLXF_HLJCZ t")
    List<Map<String,Object>> getHLJCZInfo() throws Exception;

    @Select("select * from T_SLXF_JCZ t")
    List<Map<String,Object>> getJCZInfo() throws Exception;

    @Select("select * from T_SLXF_LWT t")
    List<Map<String,Object>> getLWTInfo() throws Exception;

    @Select("select * from T_SLXF_PHDYF t")
    List<Map<String,Object>> getPHDYFInfo() throws Exception;

    @Select("select * from T_SLXF_QXZ t")
    List<Map<String,Object>> getQXZInfo() throws Exception;

    @Select("select * from T_SLXF_SYD t")
    List<Map<String,Object>> getSYDInfo() throws Exception;

    @Select("select * from T_SLXF_WZK t")
    List<Map<String,Object>> getWZKInfo() throws Exception;

    @Select("select * from T_SLXF_ZDWX t")
    List<Map<String,Object>> getZDWXInfo() throws Exception;

    @Select("select * from T_SLXF_ZYD t")
    List<Map<String,Object>> getZYDInfo() throws Exception;

}
