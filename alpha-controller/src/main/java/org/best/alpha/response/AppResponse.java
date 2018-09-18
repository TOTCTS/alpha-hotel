package org.best.alpha.response;

import org.best.alpha.manager.AssertManager;
import org.springframework.http.HttpStatus;

public class AppResponse {

    private Integer code;

    private String message;

    private Object data;

    private AppResponse(HttpStatus httpStatus, Object data) {
        AssertManager.isNull(httpStatus, "HttpStatus is not null!");
        this.code  = httpStatus.value();
        this.message = httpStatus.getReasonPhrase();
        this.data = data;
    }

    public static AppResponse success() {
        return AppResponse.success(null);
    }


    public static AppResponse success(Object data) {
        HttpStatus ok = HttpStatus.OK;
        return AppResponse.success(ok, data);
    }

    public static AppResponse success(HttpStatus httpStatus, Object date) {
        return AppResponse.instance(httpStatus, date);
    }

    public static AppResponse failure() {
        return AppResponse.failure(null);
    }

    public static AppResponse failure(Object data) {
        HttpStatus expectationFailed = HttpStatus.EXPECTATION_FAILED;
        return AppResponse.failure(expectationFailed, data);
    }

    public static AppResponse failure(HttpStatus httpStatus, Object date) {
        return AppResponse.instance(httpStatus, date);
    }


    public static AppResponse instance(HttpStatus httpStatus, Object data) {
        return new AppResponse(httpStatus, data);
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
