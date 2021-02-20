package com.clearlove.bean;

import javax.servlet.http.*;
import java.io.Serializable;

/**
 * 实现序列化接口
 * @author promise
 * @date 2020/12/5 - 21:13
 *
 * 不需要在web.xml中注册的监听器
 * HttpSessionActivationListener: HttpSessionBindingListener
 */
public class User implements Serializable, HttpSessionActivationListener, HttpSessionBindingListener {


    // session将要钝化
    @Override
    public void sessionWillPassivate(HttpSessionEvent httpSessionEvent) {
        System.out.println("User 将要和session一起钝化了");
    }

    //活化
    @Override
    public void sessionDidActivate(HttpSessionEvent httpSessionEvent) {

    }

    //检测User对象绑定到session中
    @Override
    public void valueBound(HttpSessionBindingEvent httpSessionBindingEvent) {

    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent httpSessionBindingEvent) {

    }
}
