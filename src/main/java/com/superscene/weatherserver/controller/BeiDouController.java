package com.superscene.weatherserver.controller;

import com.superscene.weatherserver.entity.BeiDou;
import com.superscene.weatherserver.entity.Result;
import com.superscene.weatherserver.mapper.BeidouMapper;
import com.superscene.weatherserver.service.impl.BeiDouServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author TanXj
 * @Date 2021/6/8
 */
@RestController
public class BeiDouController {

    @Autowired
    private BeiDouServiceImpl beiDouService;

    @RequestMapping("BeiDou/{sblx}")
    public Result getBeidouBySblx(HttpServletRequest request, @PathVariable String sblx){
        List<BeiDou> data = null;
        String code = "1";
        String inifo = "获取失败!";
        String debug = "";
        try {
            code = "0";
            inifo = "获取成功!";
            data = beiDouService.findBySblx(sblx);
        } catch (Exception e) {
            debug = e.getMessage();
        }
        return new Result(code, inifo, debug, request.getRequestURL().toString(), data);
    }
    @CrossOrigin
    @RequestMapping("BeiDou/xt")
    public Result getBeidouBySblx(HttpServletRequest request){
        List<BeiDou> data = null;
        String code = "1";
        String inifo = "获取失败!";
        String debug = "";
        try {
            data = beiDouService.queryTotalXT();
            if(data.size()>0){
                code = "0";
                inifo = "获取成功!";
            }
        } catch (Exception e) {
            debug = e.getMessage();
            return new Result(code, inifo, debug, request.getRequestURL().toString(), data);
        }finally {
            return new Result(code, inifo, debug, request.getRequestURL().toString(), data);
        }
    }
    @CrossOrigin
    @RequestMapping("BeiDou/now")
    public Result getBeidouByNow(HttpServletRequest request, @RequestParam Map<String,Object> params){
        List<BeiDou> data = new ArrayList<BeiDou>();
        String starttm= (String) params.get("starttm");
        String endtm= (String) params.get("endtm");
        String code = "1";
        String inifo = "获取失败!";
        String debug = "";
        try {
            data = beiDouService.queryByNow(starttm,endtm);
            if(data.size()>0){
                code = "0";
                inifo = "获取成功!";
            }
        } catch (Exception e) {
            debug = e.getMessage();
            return new Result(code, inifo, debug, request.getRequestURL().toString(), data);
        }finally {
            return new Result(code, inifo, debug, request.getRequestURL().toString(), data);
        }
    }
    @CrossOrigin
    @RequestMapping("BeiDou/alltoday")
    public Result getBeidouAllByToday(HttpServletRequest request, @RequestParam Map<String,Object> params){
        List<BeiDou> data = new ArrayList<BeiDou>();
        String starttm= (String) params.get("starttm");
        String endtm= (String) params.get("endtm");
        String code = "1";
        String inifo = "获取失败!";
        String debug = "";
        try {
            data = beiDouService.queryAllByToday(starttm,endtm);
            if(data.size()>0){
                code = "0";
                inifo = "获取成功!";
            }
        } catch (Exception e) {
            debug = e.getMessage();
            return new Result(code, inifo, debug, request.getRequestURL().toString(), data);
        }finally {
            return new Result(code, inifo, debug, request.getRequestURL().toString(), data);
        }
    }
    @CrossOrigin
    @RequestMapping("BeiDou/online")
    public Result getBeidouOnline(HttpServletRequest request){
        List<BeiDou> data = new ArrayList<BeiDou>();
        String code = "1";
        String inifo = "获取失败!";
        String debug = "";
        try {
            data = beiDouService.queryByOnline();
            if(data.size()>0){
                code = "0";
                inifo = "获取成功!";
            }
        } catch (Exception e) {
            debug = e.getMessage();
            return new Result(code, inifo, debug, request.getRequestURL().toString(), data);
        }finally {
            return new Result(code, inifo, debug, request.getRequestURL().toString(), data);
        }
    }
    @CrossOrigin
    @RequestMapping("BeiDou/outline")
    public Result getBeidouOutline(HttpServletRequest request){
        List<BeiDou> data = new ArrayList<BeiDou>();
        String code = "1";
        String inifo = "获取失败!";
        String debug = "";
        try {
            data = beiDouService.queryByOutline();
            if(data.size()>0){
                code = "0";
                inifo = "获取成功!";
            }
        } catch (Exception e) {
            debug = e.getMessage();
            return new Result(code, inifo, debug, request.getRequestURL().toString(), data);
        }finally {
            return new Result(code, inifo, debug, request.getRequestURL().toString(), data);
        }
    }
//    @CrossOrigin
    @RequestMapping("BeiDou/xt/dwdm")
    public Result getBeidouByDWDM(HttpServletRequest request, @RequestParam Map<String,Object> params){
        List<BeiDou> data  = new ArrayList<BeiDou>();
        String dwdm= (String) params.get("dwdm");
        String code = "1";
        String inifo = "获取失败!";
        String debug = "";
        try {
            data = beiDouService.queryXTByDWDM(dwdm);
            if(data.size()>0){
                code = "0";
                inifo = "获取成功!";
            }
        } catch (Exception e) {
            debug = e.getMessage();
            return new Result(code, inifo, debug, request.getRequestURL().toString(), data);
        }finally {
            return new Result(code, inifo, debug, request.getRequestURL().toString(), data);
        }
//        return new Result(code, inifo, debug, request.getRequestURL().toString(), data);
    }
    @CrossOrigin
    @RequestMapping("BeiDou/xt/time")
    public Result getBeidouByTime(HttpServletRequest request, @RequestParam Map<String,Object> params){
        List<BeiDou> data = new ArrayList<BeiDou>();
        String starttm= (String) params.get("starttm");
        String endtm= (String) params.get("endtm");
        String code = "1";
        String inifo = "获取失败!";
        String debug = "";
        try {
            data = beiDouService.queryXTByTime(starttm,endtm);
            if(data.size()>0){
                code = "0";
                inifo = "获取成功!";
            }
        } catch (Exception e) {
            debug = e.getMessage();
            return new Result(code, inifo, debug, request.getRequestURL().toString(), data);
        }finally {
            return new Result(code, inifo, debug, request.getRequestURL().toString(), data);
        }
    }
    @RequestMapping("BeiDou_all")
    public Result getBeidouPoint(HttpServletRequest request){
        List<BeiDou> data = null;
        String code = "1";
        String inifo = "获取失败!";
        String debug = "";
        try {
            code = "0";
            inifo = "获取成功!";
            data = beiDouService.findByTody();
        } catch (Exception e) {
            debug = e.getMessage();
        }
        return new Result(code, inifo, debug, request.getRequestURL().toString(), data);
    }
    @RequestMapping("BeiDou_path")
    public Result getBeidouPath(HttpServletRequest request, @RequestParam Map<String,Object> params){
        List<BeiDou> data = null;
        String gpsid= (String) params.get("gpsid");
        String starttm= (String) params.get("starttm");
        String endtm= (String) params.get("endtm");
        String code = "1";
        String inifo = "获取失败!";
        String debug = "";
        try {
            code = "0";
            inifo = "获取成功!";
            data = beiDouService.findByPath(gpsid,starttm,endtm);
        } catch (Exception e) {
            debug = e.getMessage();
        }
        return new Result(code, inifo, debug, request.getRequestURL().toString(), data);
    }
}
