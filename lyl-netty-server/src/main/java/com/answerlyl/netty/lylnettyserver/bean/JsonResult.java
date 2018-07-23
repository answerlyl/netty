package com.answerlyl.netty.lylnettyserver.bean;

/**
 * @author LYL
 */
public class JsonResult {

    private String status = null;

    private String statusCode = null;

    private Object result = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }
}
