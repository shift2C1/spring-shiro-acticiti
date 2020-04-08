package com.pipichao.config;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 异常解析器
 *
 * */

@Component
@Slf4j
public class TotalExceptionHandler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        log.info("异常解析");
        log.error("请求方法："+o);// 参数 o 指得是当前调用的方法
        log.error(e.getMessage());
//        ModelAndView modelAndView =new ModelAndView("500.html");
//        return modelAndView;
        JSONObject jsonObject =new JSONObject();
//        jsonObject.put("msg",e.getMessage());
        //对拦截的异常做统一的处理
        if (e instanceof AuthorizationException){
            jsonObject.put("msg","认证授权失败");
        }else {
            e.printStackTrace();
        }
        try {
            httpServletResponse.getWriter().write(jsonObject.toJSONString());
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return null;
    }
}
