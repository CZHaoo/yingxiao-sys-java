package com.zhijian.market.core.util;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


public class IpUtil {

    /**
     * 在很多应用下都可能有需要将用户的真实IP记录下来，这时就要获得用户的真实IP地址，在JSP里，获取客户端的IP地
     * 址的方法是：request.getRemoteAddr()，这种方法在大部分情况下都是有效的。但是在通过了Apache,Squid等
     * 反向代理软件就不能获取到客户端的真实IP地址了。
     * 但是在转发请求的HTTP头信息中，增加了X－FORWARDED－FOR信息。用以跟踪原有的客户端IP地址和原来客户端请求的服务器地址。
     *
     * @param request
     * @return
     */

    public static String getClientIp(HttpServletRequest request) {

        String ip = request.getHeader("X-real-ip");
        if (StringUtil.isNotNull(ip)) {
            return ip;
        }

        ip = request.getHeader("x-forwarded-for");
        //String ip = request.getHeader("X-real-ip");

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (StringUtil.isNotNull(ip)) {
            ip = ip.split(",")[0];
        }
        return ip;

    }

    public static String getClientIp() {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest req = sra.getRequest();
        return getClientIp(req);
    }
}


