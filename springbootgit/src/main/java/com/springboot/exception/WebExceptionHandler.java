package com.springboot.exception;

import com.springboot.pojo.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author  by sunshine on 2018/9/19.
 */
@ControllerAdvice
public class WebExceptionHandler {
    public static final String ERROR_VIEW="error";

    @Autowired
    private MappingJackson2HttpMessageConverter jsonConverter;
    /**
     * 异常类的全局配置，相当不错的
     * 当界面出现错误的时候，在这里可以进行处理
     * 不会出现那种500的错误了
     */
    //@ExceptionHandler(value =Exception.class)
//    public Object objectHandler(HttpServletRequest request,
//                                HttpServletResponse response,Exception e)throws Exception{
//        e.printStackTrace();
//        ModelAndView modelAndView=new ModelAndView();
//        modelAndView.addObject("exception",e);
//        modelAndView.addObject("url",request.getRequestURI());
//        modelAndView.setViewName(ERROR_VIEW);
//        return modelAndView;
//    }


    /**
     * ajax和web进行在一个类中进行判断
     */
    @ExceptionHandler(value =Exception.class)
    public Object ajaxAndWeb(HttpServletRequest request,
            HttpServletResponse response,Exception e) throws IOException {
        if(isAjax(request)){
            JsonResult jsonResult=JsonResult.errorException(e.getMessage());
            jsonConverter.write(jsonResult, MediaType.APPLICATION_JSON,new ServletServerHttpResponse(response));
            return null;
        }else{
            ModelAndView modelAndView=new ModelAndView();
            modelAndView.addObject("url",request.getRequestURI());
            modelAndView.addObject("exception",e);
            modelAndView.setViewName(ERROR_VIEW);
            return modelAndView;
        }

    }

    /**
     * 判断一个请求是否是ajax
     */
     public static boolean isAjax(HttpServletRequest request){
         return (request.getHeader("X-Requested-With")!=null
                 && "XMLHttpRequest".equals(request.getHeader("X-Requested-With").toString()));
     }
}
