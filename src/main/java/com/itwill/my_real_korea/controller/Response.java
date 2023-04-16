package com.itwill.my_real_korea.controller;

import java.io.Serializable;

import lombok.Data;
@Data
public class Response implements Serializable {

    private int code;
    private String message;
    private Object data = null;

    public Response() {
        this.code = 0;
        this.message = "";
    }
}