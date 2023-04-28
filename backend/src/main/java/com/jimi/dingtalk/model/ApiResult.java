package com.jimi.dingtalk.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class ApiResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    //@ApiModelProperty(name = "isOk", value = "请求是否成功", example = "true")
    private Boolean isOk;

    //@ApiModelProperty(name = "code", value = "请求是否成功", example = "1")
    private Integer code;

    //@ApiModelProperty(name = "msg", value = "请求是否成功", example = "1111")
    private String msg;

    //@ApiModelProperty(name = "data", value = "数据内容")
    private T data;

    public static ApiResult<Void> error(){

        ApiResult<Void> result = new ApiResult<Void>();
        result.setIsOk(false);
        result.setCode(999);
        result.setMsg("未知异常");
        return result;
    }

    // 自定义异常拦截，错误码500，异常信息
    public static ApiResult<Void> error(String msg){

        ApiResult<Void> result = new ApiResult<Void>();
        result.setIsOk(false);
        result.setCode(500);
        result.setMsg(msg);
        return result;
    }

    public static ApiResult<Void> error(Integer errorCode, String message){

        ApiResult<Void> result = new ApiResult<Void>();
        result.setIsOk(false);
        result.setCode(errorCode);
        result.setMsg(message);
        return result;
    }

    public static <T> ApiResult<T> error(String message, T o){

        ApiResult<T> result = new ApiResult<T>();
        result.setIsOk(false);
        result.setCode(500);
        result.setMsg(message);
        result.setData(o);
        return result;
    }

    public static ApiResult<Void> success(){

        ApiResult<Void> result = new ApiResult<Void>();
        result.setIsOk(true);
        result.setCode(200);
        result.setMsg("success");
        return result;
    }


    public static <T> ApiResult<T> success(T o){

        ApiResult<T> result = new ApiResult<T>();
        result.setIsOk(true);
        result.setCode(200);
        result.setMsg("success");
        result.setData(o);
        return result;
    }

    public static <T> ApiResult<T> success(String msg, T o){

        ApiResult<T> result = new ApiResult<T>();
        result.setIsOk(true);
        result.setCode(200);
        result.setMsg(msg);
        result.setData(o);
        return result;
    }
}
