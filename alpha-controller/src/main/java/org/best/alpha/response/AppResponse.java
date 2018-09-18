package org.best.alpha.response;

import org.best.alpha.enums.ResponseStatus;
import org.best.alpha.util.Assert;

public class AppResponse {

    private Integer code;

    private String message;

    private Object data;

    private AppResponse(ResponseStatus responseStatus, Object data) {
        Assert.isNull(responseStatus, "HttpStatus is null!");
        this.code  = responseStatus.getStatus();
        this.message = responseStatus.getMessage();
        this.data = data;
    }

    public static AppResponse success() {
        return AppResponse.success((Object) null);
    }

    public static AppResponse success(ResponseStatus responseStatus) {
        return AppResponse.success(responseStatus, null);
    }

    public static AppResponse success(Object data) {
        ResponseStatus ok = ResponseStatus.OK;
        return AppResponse.success(ok, data);
    }

    public static AppResponse success(ResponseStatus responseStatus, Object date) {
        return AppResponse.instance(responseStatus, date);
    }

    public static AppResponse failure() {
        return AppResponse.failure((Object) null);
    }

    public static AppResponse failure(ResponseStatus responseStatus) {
        return AppResponse.failure(responseStatus, null);
    }

    public static AppResponse failure(Object data) {
        ResponseStatus serviceUnavailable = ResponseStatus.SERVICE_UNAVAILABLE;
        return AppResponse.failure(serviceUnavailable, data);
    }

    public static AppResponse failure(ResponseStatus httpStatus, Object date) {
        return AppResponse.instance(httpStatus, date);
    }


    private static AppResponse instance(ResponseStatus responseStatus, Object data) {
        return new AppResponse(responseStatus, data);
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "AppResponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
