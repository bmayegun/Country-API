package com.biz.countries.response;

public class SuccessResponse<T> extends Response{
    private Object data;
    T meta;

    public SuccessResponse() {
        setStatus(true);
    }

    public SuccessResponse(Object data) {
        this.data = data;
        setStatus(true);
    }
    public SuccessResponse(Object data, T meta) {
        this.data = data;
        this.meta = meta;
        setStatus(true);
    }

    public Object getData() {
        return data;
    }
}
