package com.superscene.weatherserver.filter;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 自定义被动退出监听器
 */
public class CustomLogOutListener implements HttpSessionListener {

    private CustomLogOutHandler customLogOutHandler;

    public CustomLogOutListener(CustomLogOutHandler handler) {
        this.customLogOutHandler = handler;
    }

    @Override
    public void sessionDestroyed(final HttpSessionEvent event) {
        System.out.println("被动退出");
        customLogOutHandler.hanld(event);
    }
}
