package com.ecommercemicroservices.productservice.model;

public class Response {

    private String message;
    private Object data;

    public Response(String message) {
        this.message = message;
    }

    public Response(Object data) {
        this.data = data;
    }

    public Response(String message, Object data) {
        this.message = message;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
