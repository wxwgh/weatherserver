package com.superscene.weatherserver.filter;

import com.dragonsoft.dcuc.client.authentication.AuthenticationFilter;
import com.dragonsoft.dcuc.client.session.SingleSignOutFilter;
import com.dragonsoft.dcuc.client.session.SingleSignOutHttpSessionListener;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * 过滤器参数配置
 */
//@Configuration
public class FilterConfig {

    //单点登录
    private String urlFilter = "/*";

    //单点登录
    //private String urlFilter = "/no";


    /**
     * 被动退出session监听器
     */
    @Bean
    public SingleSignOutHttpSessionListener singleSignOutHttpSessionListener(){
        return new SingleSignOutHttpSessionListener();
    }

    /**
     * 被动退出时使用
     * 客户端自定义被动退出时的Listener
     * 根据客户端需求自由扩展
     * 该示例是获取内存中的key-value,并删除
     * @return
     */
    @Bean
    public CustomLogOutListener customLogOutListener(CustomLogOutHandler handler){
        return new CustomLogOutListener(handler);
    }



    @Bean
    public FilterRegistrationBean loginFilterRegistrationBean(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setName("loginFilter");
        LoginFilter loginFilter=new LoginFilter();
        registrationBean.setFilter(loginFilter);
        registrationBean.setOrder(3);
        List<String> urlList = new ArrayList<String>();
        urlList.add(urlFilter);
        registrationBean.setUrlPatterns(urlList);
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean authenticationFilterBean(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setName("authenticationFilter");
        AuthenticationFilter authenticationFilter = new AuthenticationFilter();
        registrationBean.setFilter(authenticationFilter);
        registrationBean.setOrder(2);
        List<String> urlList = new ArrayList<String>();
        urlList.add(urlFilter);
        registrationBean.setUrlPatterns(urlList);
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean CASSignOutFilterRegistration() {
        FilterRegistrationBean<SingleSignOutFilter> registration = new FilterRegistrationBean();
        registration.setFilter(new SingleSignOutFilter());
        registration.addUrlPatterns(new String[]{urlFilter});
        registration.setName("CASSignOutFilter");
        registration.setOrder(1);
        return registration;
    }
}
