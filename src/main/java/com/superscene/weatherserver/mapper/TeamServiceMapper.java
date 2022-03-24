package com.superscene.weatherserver.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: TeamServiceMapper
 * @Description: TODO
 * @AUTHOR:ZXY
 * @DATE:2020/4/15 14:34
 **/
@Repository
public interface TeamServiceMapper {

    @Select("select * from bigscreen.VW_SLXFJ_SJTJ_DWDM t")
    List<Map<String,Object>> getDWDMInfo() throws Exception;

    @Select("select * from bigscreen.vw_slxfj_sjtj_ryzb t where t.总队=#{zd} and t.支队 is null")
    List<Map<String,Object>> getRYZBZDInfo(String zd) throws Exception;

    @Select("select * from bigscreen.vw_slxfj_sjtj_ryzb t where t.总队=#{zd} and t.支队 = #{zhd} and t.大中队 is null")
    List<Map<String,Object>> getRYZBZHDInfo(String zd,String zhd) throws Exception;

    @Select("select * from bigscreen.vw_slxfj_sjtj_ryzb t where t.总队=#{zd} and t.支队 = #{zhd} and t.大中队 = #{dzd}")
    List<Map<String,Object>> getRYZBDZDInfo(String zd,String zhd,String dzd) throws Exception;

    @Select("select t1.*, t2.纬度, t2.经度,t2.地址 from bigscreen.vw_slxfj_sjtj_ryzb t1 inner join bigscreen.VW_SLXFJ_SJTJ_DWDM t2 on t1.关联字段 = t2.关联字段 where t1.总队 is not null and t1.支队 is not null and t1.大中队 is not null and t2.经度 is not null and t2.纬度 is not null")
    List<Map<String,Object>> getDZDInfo();

    @Select("select t1.*, t2.纬度, t2.经度,t2.地址 from bigscreen.vw_slxfj_sjtj_ryzb t1 inner join bigscreen.VW_SLXFJ_SJTJ_DWDM t2 on t1.关联字段 = t2.关联字段 where t1.总队 is not null and t1.支队 is not null and t1.大中队 is null and t2.经度 is not null and t2.纬度 is not null")
    List<Map<String,Object>> getZHDInfo();

    @Select("select t1.*, t2.纬度, t2.经度,t2.地址 from bigscreen.vw_slxfj_sjtj_ryzb t1 inner join bigscreen.VW_SLXFJ_SJTJ_DWDM t2 on t1.关联字段 = t2.关联字段 where t1.总队 is not null and t1.支队 is null and t1.大中队 is null and t2.经度 is not null and t2.纬度 is not null")
    List<Map<String,Object>> getZDInfo();

}
