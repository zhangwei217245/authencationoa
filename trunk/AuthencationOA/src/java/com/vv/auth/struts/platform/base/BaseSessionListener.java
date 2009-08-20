package com.vv.auth.struts.platform.base;

import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class BaseSessionListener implements HttpSessionListener {

    public void sessionCreated(HttpSessionEvent session) {
        System.out.println("sessionCreated-----------------------" + session.getSession().getId());
    }

    /**
     * ���sessionʧЧ��ɾ��
     */
    public void sessionDestroyed(HttpSessionEvent session) {
        System.out.println("sessionDestroyed-----------------------" + session.getSession().getId());
    }
}
