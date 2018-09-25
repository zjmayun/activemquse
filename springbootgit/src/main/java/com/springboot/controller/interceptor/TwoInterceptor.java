package com.springboot.controller.interceptor;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.springboot.pojo.JsonResult;
import com.springboot.utils.JsonUtils;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by sunshine on 2018/9/25.
 */
public class TwoInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(true){
            errorJsonMsg(response,JsonResult.errorException("请求被拦截器2进行拦截"));
        }

        System.out.println("hello interceptor2");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        System.out.println("hello interceptor2");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {

    }

    //当拦截器被拦截时，返回的json
    public void errorJsonMsg(HttpServletResponse response, JsonResult result) throws IOException {
        OutputStream out=null;
        try {
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/json");
            out=response.getOutputStream();
            out.write(JsonUtils.objectToJson(result).getBytes("utf-8"));
            out.flush();
        }finally {
            if(out!=null){
                out.close();
            }
        }
    }
}
