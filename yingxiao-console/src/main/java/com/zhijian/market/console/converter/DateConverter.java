package com.zhijian.market.console.converter;

import com.zhijian.market.core.util.StringUtil;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期转换器
 */
@Component
public class DateConverter implements Converter<String, Date> {

    private static final String[] datePatterns = {"yyyy-MM-dd HH:mm:ss","yyyy-MM-dd HH:mm","yyyy-MM-dd","yyyy-MM"};

    @Override
    public Date convert(String dateStr) {
        if (StringUtil.isNull(dateStr)) {
            return null;
        }

        return parse(dateStr);

    }

    private Date parse(String dateStr) {

        for (String datePattern : datePatterns) {
            SimpleDateFormat sdf = new SimpleDateFormat(datePattern);
            try {
               return sdf.parse(dateStr);
            } catch (ParseException e) {
               // System.out.println("continue");
            }
        }
        return null;
    }

    public static void main(String[] args) {
        DateConverter c = new DateConverter();
        System.out.println(c.parse("2016-11-22"));
    }
}
