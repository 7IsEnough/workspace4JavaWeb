package com.clearlove.i18n;

import org.junit.Test;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author promise
 * @date 2020/12/7 - 20:48
 * Locale代表区域信息：
 * java OOP:
 * 每一个区域我们可以用一个Locale对象来表示
 */
public class LocaleTest {

    @Test
    public void test01(){
        // 获取所有的区域信息
        // zh_CN：语言代码_国家代码
        Locale[] locales = Locale.getAvailableLocales();
//        for (Locale locale : locales) {
//            System.out.println(locale);
//        }

        // 1.判断当前系统所处在哪个国家环境下：得到不同信息
        Locale default1 = Locale.getDefault();
        System.out.println(default1);
    }

    /***
     * Locale：区域信息
     * ResourceBundle: 资源绑定；管理资源
     * bookstore_zh_CN.properties:保存一些k=v
     * 1.将我们要按照区域信息不同要动态显示的信息放在配置文件(国际化配置文件)中
     *  要求： 起名：  基础名_语言代码_国家代码.properties
     * 2.ResourceBundle来绑定所有的国际化资源文件：(管理国际化资源文件)
     */
    @Test
    public void test02(){
        Locale china = Locale.CHINA;
        Locale us = Locale.US;

        //1.根据区域信息管理国际化资源文件
        ResourceBundle bundle = ResourceBundle.getBundle("bookstore", us);
        //2.根据当前区域动态的获取到国际化配置文件中某个key的值
        String username = bundle.getString("username");
        System.out.println(username);
    }
}
