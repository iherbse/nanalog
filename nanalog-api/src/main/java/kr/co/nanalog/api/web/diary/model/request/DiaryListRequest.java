package kr.co.nanalog.api.web.diary.model.request;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * Created by lcw on 7/26/16.
 */
public class DiaryListRequest {

    @NotNull
    @NotEmpty
    private String uid;
    private Integer month;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    @Override
    public String toString() {
        return "DiaryGetRequest{" +
                "uid='" + uid + '\'' +
                ", month=" + month +
                '}';
    }
}
