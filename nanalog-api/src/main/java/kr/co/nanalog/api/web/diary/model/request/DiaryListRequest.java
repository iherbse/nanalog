package kr.co.nanalog.api.web.diary.model.request;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by lcw on 7/26/16.
 */
public class DiaryListRequest {

    @NotNull
    @NotEmpty
    private String uid;
    private Integer date;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "DiaryListRequest{" +
                "uid='" + uid + '\'' +
                ", date=" + date +
                '}';
    }
}
