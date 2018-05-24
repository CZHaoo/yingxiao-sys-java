package com.zhijian.market.core.util;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {

    public static Date buildDate(int year,int month,int day) {
        Calendar c = new GregorianCalendar(year,month,day);
        return c.getTime();
    }

    public static void main(String[] args) {
        System.out.println(new Date());
        System.out.println(currMonthOfFirstDay());
        System.out.println(nextMonthOfFirstDay());
    }

    /**
     * 当前月份的第一天
     * @return
     */
    public static Date currMonthOfFirstDay() {
        ZoneId zoneId = ZoneId.systemDefault(); //当前服务器 时区
        LocalDate localDate = LocalDate.now().withDayOfMonth(1);
        ZonedDateTime zdt = localDate.atStartOfDay(zoneId); // localDate -> ZonedDateTime
        return Date.from(zdt.toInstant());
    }

    /**
     * 下个月的第一天
     * @return
     */
    public static Date nextMonthOfFirstDay() {
        ZoneId zoneId = ZoneId.systemDefault(); //当前服务器 时区
        LocalDate localDate = LocalDate.now().plusMonths(1).withDayOfMonth(1);
        ZonedDateTime zdt = localDate.atStartOfDay(zoneId); // localDate -> ZonedDateTime
        return Date.from(zdt.toInstant()); // ZoneDateTime -> Date
    }
}
