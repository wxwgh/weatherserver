package com.superscene.weatherserver.controller;

import com.dragonsoft.dcuc.client.logout.DcucLogoutHandler;
import com.dragonsoft.dcuc.common.util.PropUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@RestController
public class LogoutController {

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response)throws UnsupportedEncodingException {
//        if (!isAjaxRequest(request)){
//            //退出后重定向的地址,必须包含ip、Port和上下文的完整路径（如http://127.0.0.1:8080/ssotest/）
//            String redirectUrl = request.getParameter("redirectUrl");
//            if (StringUtils.isEmpty(redirectUrl)){
//                redirectUrl = PropUtils.getInstance().getConfigItem("dcuc.serverName");
//            }
//            //单点登录退出
//            DcucLogoutHandler.logout(request, response, redirectUrl);
//            return null;
//        } else {
//            //清除session
//            HttpSession session = request.getSession();
//            if (session != null) {
//                session.invalidate();
//            }
//            //拼装单点登录退出方法给前端
//            String logoutUrl = PropUtils.getInstance().getConfigItem("dcuc.casServerUrlPrefix") + "/logout";
//            String redirectUrl = request.getParameter("redirectUrl");
//            if (StringUtils.isEmpty(redirectUrl)){
//                redirectUrl = PropUtils.getInstance().getConfigItem("dcuc.serverName");
//            }
//            logoutUrl = logoutUrl+"?service="+redirectUrl;
//            return logoutUrl;
//        }
        //拼装单点登录退出方法给前端
        String logoutUrl = PropUtils.getInstance().getConfigItem("dcuc.casServerLoginUrl") + "/logout";
        String redirectUrl = PropUtils.getInstance().getConfigItem("dcuc.appUrl");
        logoutUrl = logoutUrl+"?service="+ redirectUrl;
        return logoutUrl;
    }

    public boolean isAjaxRequest(HttpServletRequest request){
        //判断是否为ajax请求
        String requestType = request.getHeader("X-Requested-With");
        if ("XMLHttpRequest".equals(requestType)){
            return true;
        }
        return false;
    }
}
