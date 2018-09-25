package com.springboot.exception;

import com.springboot.pojo.JsonResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author  by sunshine on 2018/9/19.
 */
//@RestControllerAdvice
public class AjaxExceptionHandler {

    /**
     * 异常类的全局配置，相当不错的
     * 这里采用的是ajax的形式，应该返回json数据
     */
    //@ExceptionHandler(value=Exception.class)
    public JsonResult ajaxHandler(HttpServletRequest request, Exception e)throws Exception{
        e.printStackTrace();
        return JsonResult.errorException(e.getMessage());
    }
}
