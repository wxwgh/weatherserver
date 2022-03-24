package com.superscene.weatherserver.filter;

import org.jasig.cas.client.validation.Assertion;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import java.util.Map;

/**
 * 客户端自定义被动退出时的具体的处理类
 * 根据客户端需求自由扩展
 * 该示例是获取内存中的key-value,并删除
 */

//@Component
public class CustomLogOutHandler {

    public static final String CONST_CAS_ASSERTION = "_const_cas_assertion_";

    public void hanld(HttpSessionEvent event) {
        HttpSession session = event.getSession();
        final Assertion assertion = session != null ? (Assertion) session.getAttribute(CONST_CAS_ASSERTION) : null;
        if(null != assertion){
            String userId = assertion.getPrincipal().getName();
            Map<String, String> map = InternalMemHolder.getMap();
            String value = map.get(userId);
            System.out.println("退出用户key-value："+userId+"——————"+value);
            boolean b = map.remove(userId, value);
            System.out.println(b);
        }
    }
}
