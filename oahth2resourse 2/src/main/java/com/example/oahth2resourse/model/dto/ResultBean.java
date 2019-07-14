package com.example.oahth2resourse.model.dto;

import java.io.Serializable;

/**
 * @author lucky_yh
 * 2019/7/3 21:42
 */
public class ResultBean<T> implements Serializable {

    private Integer code;
    private String message;
    private T data;

    public ResultBean(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
