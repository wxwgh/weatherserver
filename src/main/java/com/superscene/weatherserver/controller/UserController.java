package com.superscene.weatherserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping({"/user"})
public class UserController {

    /**
     * 获取用户信息
     * @param request
     * @return
     */
    @RequestMapping(value = {"info"}, method = {RequestMethod.GET})
    @ResponseBody
    public String info(HttpServletRequest request) {
        try {
            String userId = request.getSession().getAttribute("securityUser")!=null?request.getSession().getAttribute("securityUser").toString():null;
            System.out.println("cp---------------------"+userId);
            return userId;
        } catch (Exception var3) {
            throw new SecurityException("获取用户信息异常", var3);
        }
    }
}
