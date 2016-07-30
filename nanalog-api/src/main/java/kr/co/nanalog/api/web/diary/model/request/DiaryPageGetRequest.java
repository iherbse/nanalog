package kr.co.nanalog.api.web.diary.model.request;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by lcw on 7/30/16.
 */
public class DiaryPageGetRequest {

    @NotEmpty
    @NotNull
    private String uid;
    private Date date;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "DiaryPageGetRequest{" +
                "uid='" + uid + '\'' +
                ", date=" + date +
                '}';
    }
}
