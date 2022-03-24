package com.superscene.weatherserver.controller;

import com.superscene.weatherserver.entity.MessageDao;
import com.superscene.weatherserver.entity.Result;
import com.superscene.weatherserver.service.impl.MessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @Author wxw
 * @Date 2022/2/28
 */


@RestController
public class MessageController {

    @Autowired
    private MessageServiceImpl messageServiceImpl;
    @CrossOrigin
    @RequestMapping("Message")
    public Result getMessageAll(HttpServletRequest request,@RequestParam Map<String,Object> params){
        List<MessageDao> data = null;
        String starttm= (String) params.get("starttm");
        String endtm= (String) params.get("endtm");
        String code = "1";
        String inifo = "获取失败!";
        String debug = "";
        try {
            data = messageServiceImpl.queryByToday(starttm,endtm);
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
    @RequestMapping("Message_time")
    public Result getMessageByTime(HttpServletRequest request,@RequestParam Map<String,Object> params){
        List<MessageDao> data = null;
        String starttm= (String) params.get("starttm");
        String endtm= (String) params.get("endtm");
        String code = "1";
        String inifo = "获取失败!";
        String debug = "";
        data = messageServiceImpl.queryByTime(starttm,endtm);
        if(data.size()>0){
            code = "0";
            inifo = "获取成功!";
        }
        return new Result(code, inifo, debug, request.getRequestURL().toString(), data);
    }
}
