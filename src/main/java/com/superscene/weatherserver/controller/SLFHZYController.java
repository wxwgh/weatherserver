package com.superscene.weatherserver.controller;

import com.superscene.weatherserver.entity.Result;
import com.superscene.weatherserver.service.ISLFHZYService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: SLFHZYController
 * @Description: TODO
 * @AUTHOR:ZZQ
 * @DATE:2021/10/31 12:32
 **/
@Slf4j
@RestController
@RequestMapping({"/slfhzy"})
public class SLFHZYController {

    @Autowired
    private ISLFHZYService iSLFHZYService;

    @RequestMapping(value = {"/bzydw"},method = {RequestMethod.GET})
    public  Result getBZYDWInfo(HttpServletRequest request){
        List<Map<String, Object>> restList = new ArrayList<>();
        String code = "1";
        String inifo = "错误!";
        String debug = "";
        try {
            code = "0";
            inifo = "成功!";
            restList = iSLFHZYService.getBZYDWInfo();
        } catch (Exception e) {
            debug = e.getMessage();
        }
        return new Result(code, inifo, debug, request.getRequestURL().toString(), restList);
    }

    @RequestMapping(value = {"/fhzhb"},method = {RequestMethod.GET})
    public  Result getFHZHBInfo(HttpServletRequest request){
        List<Map<String, Object>> restList = new ArrayList<>();
        String code = "1";
        String inifo = "错误!";
        String debug = "";
        try {
            code = "0";
            inifo = "成功!";
            restList = iSLFHZYService.getFHZHBInfo();
        } catch (Exception e) {
            debug = e.getMessage();
        }
        return new Result(code, inifo, debug, request.getRequestURL().toString(), restList);
    }

    @RequestMapping(value = {"/hljcz"},method = {RequestMethod.GET})
    public  Result getHLJCZInfo(HttpServletRequest request){
        List<Map<String, Object>> restList = new ArrayList<>();
        String code = "1";
        String inifo = "错误!";
        String debug = "";
        try {
            code = "0";
            inifo = "成功!";
            restList = iSLFHZYService.getHLJCZInfo();
        } catch (Exception e) {
            debug = e.getMessage();
        }
        return new Result(code, inifo, debug, request.getRequestURL().toString(), restList);
    }

    @RequestMapping(value = {"/jcz"},method = {RequestMethod.GET})
    public  Result getJCZInfo(HttpServletRequest request){
        List<Map<String, Object>> restList = new ArrayList<>();
        String code = "1";
        String inifo = "错误!";
        String debug = "";
        try {
            code = "0";
            inifo = "成功!";
            restList = iSLFHZYService.getJCZInfo();
        } catch (Exception e) {
            debug = e.getMessage();
        }
        return new Result(code, inifo, debug, request.getRequestURL().toString(), restList);
    }

    @RequestMapping(value = {"/lwt"},method = {RequestMethod.GET})
    public  Result getLWTInfo(HttpServletRequest request){
        List<Map<String, Object>> restList = new ArrayList<>();
        String code = "1";
        String inifo = "错误!";
        String debug = "";
        try {
            code = "0";
            inifo = "成功!";
            restList = iSLFHZYService.getLWTInfo();
        } catch (Exception e) {
            debug = e.getMessage();
        }
        return new Result(code, inifo, debug, request.getRequestURL().toString(), restList);
    }

    @RequestMapping(value = {"/phdyf"},method = {RequestMethod.GET})
    public  Result getPHDYFInfo(HttpServletRequest request){
        List<Map<String, Object>> restList = new ArrayList<>();
        String code = "1";
        String inifo = "错误!";
        String debug = "";
        try {
            code = "0";
            inifo = "成功!";
            restList = iSLFHZYService.getPHDYFInfo();
        } catch (Exception e) {
            debug = e.getMessage();
        }
        return new Result(code, inifo, debug, request.getRequestURL().toString(), restList);
    }

    @RequestMapping(value = {"/qxz"},method = {RequestMethod.GET})
    public  Result getQXZInfo(HttpServletRequest request){
        List<Map<String, Object>> restList = new ArrayList<>();
        String code = "1";
        String inifo = "错误!";
        String debug = "";
        try {
            code = "0";
            inifo = "成功!";
            restList = iSLFHZYService.getQXZInfo();
        } catch (Exception e) {
            debug = e.getMessage();
        }
        return new Result(code, inifo, debug, request.getRequestURL().toString(), restList);
    }

    @RequestMapping(value = {"/syd"},method = {RequestMethod.GET})
    public  Result getSYDInfo(HttpServletRequest request){
        List<Map<String, Object>> restList = new ArrayList<>();
        String code = "1";
        String inifo = "错误!";
        String debug = "";
        try {
            code = "0";
            inifo = "成功!";
            restList = iSLFHZYService.getSYDInfo();
        } catch (Exception e) {
            debug = e.getMessage();
        }
        return new Result(code, inifo, debug, request.getRequestURL().toString(), restList);
    }

    @RequestMapping(value = {"/wzk"},method = {RequestMethod.GET})
    public  Result getWZKInfo(HttpServletRequest request){
        List<Map<String, Object>> restList = new ArrayList<>();
        String code = "1";
        String inifo = "错误!";
        String debug = "";
        try {
            code = "0";
            inifo = "成功!";
            restList = iSLFHZYService.getWZKInfo();
        } catch (Exception e) {
            debug = e.getMessage();
        }
        return new Result(code, inifo, debug, request.getRequestURL().toString(), restList);
    }

    @RequestMapping(value = {"/zdwx"},method = {RequestMethod.GET})
    public  Result getZDWXInfo(HttpServletRequest request){
        List<Map<String, Object>> restList = new ArrayList<>();
        String code = "1";
        String inifo = "错误!";
        String debug = "";
        try {
            code = "0";
            inifo = "成功!";
            restList = iSLFHZYService.getZDWXInfo();
        } catch (Exception e) {
            debug = e.getMessage();
        }
        return new Result(code, inifo, debug, request.getRequestURL().toString(), restList);
    }

    @RequestMapping(value = {"/zyd"},method = {RequestMethod.GET})
    public  Result getZYDInfo(HttpServletRequest request){
        List<Map<String, Object>> restList = new ArrayList<>();
        String code = "1";
        String inifo = "错误!";
        String debug = "";
        try {
            code = "0";
            inifo = "成功!";
            restList = iSLFHZYService.getZYDInfo();
        } catch (Exception e) {
            debug = e.getMessage();
        }
        return new Result(code, inifo, debug, request.getRequestURL().toString(), restList);
    }


}
