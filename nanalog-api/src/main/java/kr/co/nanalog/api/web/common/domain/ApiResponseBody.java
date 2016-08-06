package kr.co.nanalog.api.web.common.domain;

import org.springframework.http.HttpStatus;

/**
 * Created by 1002731 on 2016. 7. 22..
 * Email : eenan@sk.com
 */
public class ApiResponseBody<T> {

    private T data;
    private Integer status_code;
    private String status_txt;

    public ApiResponseBody(T data) {
        this.data = data;
        this.status_code = HttpStatus.OK.value();
        this.status_txt = HttpStatus.OK.toString();
    }

    public ApiResponseBody(Integer status_code, String status_txt) {
        this.status_code = status_code;
        this.status_txt = status_txt;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getStatus_code() {
        return status_code;
    }

    public void setStatus_code(Integer status_code) {
        this.status_code = status_code;
    }

    public String getStatus_txt() {
        return status_txt;
    }

    public void setStatus_txt(String status_txt) {
        this.status_txt = status_txt;
    }

    @Override
    public String toString() {
        return "ApiResponseBody{" +
                "data=" + data +
                ", status_code=" + status_code +
                ", status_txt='" + status_txt + '\'' +
                '}';
    }
}
