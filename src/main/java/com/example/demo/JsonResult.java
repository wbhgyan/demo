package com.example.demo;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class JsonResult<T> {
    public static final String OK = "ok";
    private String status;
    private String msg;
    private T data;

    public static <T> JsonResult<T> ok(T data) {
        JsonResult<T> result = new JsonResult();
        result.setStatus("ok");
        result.setMsg("ok");
        result.setData(data);
        return result;
    }

    public static <T> JsonResult<T> ok() {
        return ok(null);
    }

    public static JsonResult fail(String status, String msg) {
        status = status == null ? "fail" : status;
        if ("ok".equals(status)) {
            throw new RuntimeException("ok is not fail");
        } else {
            JsonResult result = new JsonResult();
            result.setStatus(status);
            result.setMsg(msg);
            return result;
        }
    }


    public static JsonResult badRequest(String msg) {
        return fail("bad_request", msg);
    }

    @JsonIgnore
    public boolean isOk() {
        return "ok".equals(this.status);
    }

    @JsonGetter
    public long getTimestamp() {
        return System.currentTimeMillis();
    }


    public String getStatus() {
        return this.status;
    }

    public String getMsg() {
        return this.msg;
    }

    public T getData() {
        return this.data;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(T data) {
        this.data = data;
    }

}
