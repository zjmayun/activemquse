package com.springboot.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author  sunshine on 2018/9/19.
 */
public class JsonResult {
     @JsonInclude(JsonInclude.Include.NON_NULL)
     private ObjectMapper objectMapper;
    /**
     * 状态码 200成功 500 出错
     */
    private Integer status;
    private String msg;
    private Object data;

    public JsonResult(){

    }

    public JsonResult(Integer status,Object data,String msg){
        this.status=status;
        this.data=data;
        this.msg=msg;
    }

    public JsonResult(Object data){
        this.status=200;
        this.msg="ok";
        this.data=data;
    }

    /**
     * 定义成功的返回,状态码在
     * 构造函数中进行了声明
     * @return
     */
    public static JsonResult ok(Object data){
        return new JsonResult(data);
    }

    public static JsonResult ok(){
        return new JsonResult(null);
    }

    /**
     * 出现异常时的处理方式
     * @param msg
     * @return
     */
    public static JsonResult errorException(String msg){
        return new JsonResult(555,null,msg);
    }

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public String getmsg() {
        return msg;
    }

    public void setmsg(String msg) {
        this.msg = msg;
    }
}
