package com.superscene.weatherserver.filter;


import com.dragonsoft.dcuc.client.validation.DcucTicketValidationFilter;
import com.dragonsoft.dcuc.common.util.PropUtils;
import org.jasig.cas.client.util.CommonUtils;
import org.jasig.cas.client.validation.Assertion;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.UUID;

public class LoginFilter extends DcucTicketValidationFilter {


    /**
     * 单点登录登录后的回调
     * @param request
     * @param response
     * @param assertion
     *
     * @return 返回要回调的前端地址（默认为sevice的地址）
     */
    @Override
    protected String onSuccessfulValidation(HttpServletRequest request, HttpServletResponse response, Assertion assertion) {
        //获取登录用户的userId
        String userId = assertion.getPrincipal().getName();
        //从asserttion获取身份证号
        Map<String, Object> infoMap = assertion.getPrincipal().getAttributes();
        //身份证号
        String gmsfzh = (String) infoMap.get("gmsfzh");
        //人员类型 10 民警  20 辅警  30外部人员
        String userType = (String) infoMap.get("userType");
        //应用自定义登录状态的存储方式,根据应用需求编写。这里将key-value保存至内存中只是示例。
        //dcuc-client.jar是利用httpSession的方式记录用户在应用的登录状态。
        //若应用没有其他需求（例如：根据应用给用户的token进行登录校验）可不用扩展。
        //将用户相关信息缓存到内存中和session中
        String uuid = UUID.randomUUID().toString();
        System.out.println("用户key-value："+userId+"——————"+uuid);
        InternalMemHolder.getMap().put(userId,uuid);
        //将用户信息缓存到session中，在/user/info接口中获取用户信息
        request.getSession().setAttribute("securityUser",userId);
        //自定义记录登录状态结束


        //可自定义重定向地址，也可以返回null;
        //  String redirectUrl="http://10.11.1.192:8000/ssoweb/success.html";

        String redirectUrl = PropUtils.getInstance().getConfigItem("dcuc.serverName");
        if(CommonUtils.isNotEmpty(redirectUrl)) {
            //自定义
            String queryString = request.getQueryString();
            StringBuffer buffer = new StringBuffer();
            if (!CommonUtils.isEmpty(queryString)) {
                String[] params = queryString.split("&");
                for (String param : params) {
                    if (param.contains("redirectUrl")) {
                        continue;
                    }
                    buffer.append(param).append("&");
                }
            }
            String paramStr = buffer.toString();
            if (!CommonUtils.isEmpty(paramStr)) {
                paramStr = paramStr.substring(0, paramStr.length() - 1);
                redirectUrl += "?" + paramStr;
            }

        }

        return redirectUrl;

    }
}
