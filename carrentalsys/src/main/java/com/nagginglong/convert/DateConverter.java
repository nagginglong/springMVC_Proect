package com.nagginglong.convert;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * description:  针对后台接收数据参数转换格式！
 *
 * @author:像大山一样
 * @Date:2020/9/10 22:29
 */

public class DateConverter implements Converter<String, Date> {

    //基本的日期转换类
    SimpleDateFormat[] sdfs = new SimpleDateFormat[]{
            new SimpleDateFormat("yyyy-MM-dd"),
            new SimpleDateFormat("yyyyMMdd"),
            new SimpleDateFormat("yyyy年MM月dd日")};
    @Override
    public Date convert(String s) {
        if (s == null || s.isEmpty()) {

            return null;

        }
        for (SimpleDateFormat sdf : sdfs) {

            try {
                return sdf.parse(s);
            } catch (ParseException e) {
                e.printStackTrace();
                //如果捕捉到异常，就跳过这次循环开启下次循环
                continue;
            }
        }

        //如果两个都没有满足就返回null
        return null;

    }
}
