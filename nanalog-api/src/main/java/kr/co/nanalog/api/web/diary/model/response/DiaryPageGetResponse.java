package kr.co.nanalog.api.web.diary.model.response;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * Created by lcw on 7/30/16.
 */
public class DiaryPageGetResponse {

    @NotEmpty
    @NotNull
    private String uid;
    private String date;
    private List<DiaryPageGetResponseModel> diaryPageGetResponseModels;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<DiaryPageGetResponseModel> getDiaryPageGetResponseModels() {
        return diaryPageGetResponseModels;
    }

    public void setDiaryPageGetResponseModels(List<DiaryPageGetResponseModel> diaryPageGetResponseModels) {
        this.diaryPageGetResponseModels = diaryPageGetResponseModels;
    }

    @Override
    public String toString() {
        return "DiaryPageGetResponse{" +
                "uid='" + uid + '\'' +
                ", date=" + date +
                ", diaryPageGetResponseModels=" + diaryPageGetResponseModels +
                '}';
    }
}
