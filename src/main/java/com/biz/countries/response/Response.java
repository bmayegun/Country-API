package com.biz.countries.response;

public class Response {
    private boolean status;
    public Response() {
    }
    public Response(boolean status) {
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }
    protected void setStatus(boolean status) {
        this.status = status;
    }
}
