package com.zhijian.market.console.handler;


import com.zhijian.market.core.dto.RespEntity;
import com.zhijian.market.core.util.MsgUtil;
import com.zhijian.market.core.util.StringUtil;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = SQLException.class)
    public RespEntity sqlErrorHandler(HttpServletRequest req, HttpServletResponse resp, Exception e) {
        //  log.error(e.toString(), e);
        return RespEntity.fail("请求出错");
    }

    @ResponseBody
    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public RespEntity httpMessageNotReadableExceptionHandler(HttpServletRequest req, HttpServletResponse resp, Exception e) {
        // log.error(e.toString(), e);
        if (StringUtil.isNotNull(e.getMessage())) {
            String errorMsg = "";
            //"com.zhijian.option.backend.handler.GlobalDefaultExceptionHandler - JSON parse error: Can not deserialize value of type java.lang.Integer from String \"abcc\": not a valid Integer value; nested exception is com.fasterxml.jackson.databind.exc.InvalidFormatException: Can not deserialize value of type java.lang.Integer from String \"abcc\": not a valid Integer value\n at [Source: java.io.PushbackInputStream@2759f62; line: 1, column: 64] (through reference chain: com.zhijian.option.dto.backend.UserDto$PageReq[\"data\"]->com.zhijian.option.pojo.User[\"id\"])";
            String rawMessage = e.getMessage();
            //    log.info(rawMessage);
            String rgex = "Can not deserialize value of type[^\"]+\"(.*? not a valid[^;]+) value";

            //abcc": not a valid Integer
            String combinedMessage = MsgUtil.getSubUtilSimple(rawMessage, rgex);
            int startIndex = combinedMessage.indexOf("\": not a valid ");
            if (startIndex > 0) {
                errorMsg += combinedMessage.substring(0, startIndex);

                if (combinedMessage.endsWith("Integer")) {
                    errorMsg += " 不是有效的数字";
                }
            } else {
                errorMsg = combinedMessage;
            }

            return RespEntity.fail(errorMsg);
        }
        return RespEntity.fail("请求出错");
    }

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public RespEntity defaultErrorHandler(HttpServletRequest req, HttpServletResponse resp, Exception e) {
        //log.error(e.toString(), e);
        if (StringUtil.isNotNull(e.getMessage())) {
            return RespEntity.fail(e.getMessage());
        }
        return RespEntity.fail("请求出错");
    }

    public static void main(String args[]) {
//        String rgex = "Can not deserialize value of type[^\"]+(.*? not a valid[^;]+) value";
//        String message = "com.zhijian.option.backend.handler.GlobalDefaultExceptionHandler - JSON parse error: Can not deserialize value of type java.lang.Integer from String \"abcc\": not a valid Integer value; nested exception is com.fasterxml.jackson.databind.exc.InvalidFormatException: Can not deserialize value of type java.lang.Integer from String \"abcc\": not a valid Integer value\n at [Source: java.io.PushbackInputStream@2759f62; line: 1, column: 64] (through reference chain: com.zhijian.option.dto.backend.UserDto$PageReq[\"data\"]->com.zhijian.option.pojo.User[\"id\"])";
//        System.out.println(getSubUtilSimple(message, rgex));

        String rgex = "For input[^\"]+\"(.*?)\"";
        String message = "java.lang.NumberFormatException: For input string: \"a\"";
        System.out.println(MsgUtil.getSubUtilSimple(message, rgex));
    }


}
