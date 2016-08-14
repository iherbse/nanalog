package kr.co.nanalog.api.web.diary.model.request;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * Created by choijinjoo on 2016. 8. 14..
 */
public class DiaryPreviewRequest {
    @NotEmpty
    @NotNull
    private String uid;
    @NotEmpty
    @NotNull
    private String startDate;
    @NotEmpty
    @NotNull
    private String endDate;


    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "DiaryPreviewRequest{" +
                "uid='" + uid + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }
}
