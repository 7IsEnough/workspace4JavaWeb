package com.clearlove.i18n;

import org.junit.Test;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author promise
 * @date 2020/12/9 - 21:45
 */
public class I18nPlusTest {


    /**
     * java.text.Format：国际化额外支持的包
     * 支持根据不同区域国际化出不同信息
     * 2019-12-13 12:55:59:123
     * DateFormat，日期格式化
     *  getDateInstance  2019-12-13
     *  getDateTimeInstance  2019-12-13 12:55:59:123
     *  getTimeInstance  12:55:59:123
     *  Style: 日期风格
     *  FULL\LONG\MEDIUM\SHORT\DEFAULT = MEDIUM;
     *  完整\长\中\短\默认
     *
     *
     * NumberFormat，数字格式化
     *  数字：NumberFormat.getInstance(china);
     *  货币：NumberFormat.getCurrencyInstance(us);
     *
     *
     * MessageFormat,自定义消息(文本)格式化
     *  张三喜欢李四， 但是李四喜欢王五
     *  人名的信息是动态获取的
     *  国际化文件中：{0} like {1}, but {1} like {2}: 索引从0开始
     *
     *  English: 张三 like 李四， but 李四 like 王五
     *  中文：张三喜欢李四， 但是李四喜欢王五
      */

    @Test
    public void test01(){
        Locale canada = Locale.CANADA;
        Locale china = Locale.CHINA;
        Locale french = Locale.FRENCH;
        Locale us = Locale.US;
        Locale japan = Locale.JAPAN;
        Locale korea = Locale.KOREA;
        Locale italy = Locale.ITALY;

        //1.要按照区域信息格式化日期，先拿到DateFormat实例(日期格式化)
        DateFormat dateInstance = DateFormat.getDateInstance(DateFormat.SHORT, china);
        String format = dateInstance.format(new Date());
        System.out.println(format);

        //2.数字格式化
        double salary = 3213131231313.987;
        NumberFormat instance = NumberFormat.getInstance(italy);
        String string = instance.format(salary);
        System.out.println(string);

        //3.货币格式化
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(us);
        String format1 = currencyInstance.format(salary);
        System.out.println(format1);

        //4.MessageFormat：支持国际化配置文件中写动态占位符
        ResourceBundle bundle = ResourceBundle.getBundle("bookstore", us);
        String likeinfo = bundle.getString("likeinfo");
        System.out.println(likeinfo);
        String format2 = MessageFormat.format(likeinfo, "宝宝", "蓉蓉", "哲哲");
        System.out.println(format2);
    }
}
