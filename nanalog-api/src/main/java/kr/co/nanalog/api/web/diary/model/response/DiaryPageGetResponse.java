package kr.co.nanalog.api.web.diary.model.response;

import javafx.beans.DefaultProperty;
import kr.co.nanalog.api.entity.Page;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by lcw on 7/30/16.
 */
public class DiaryPageGetResponse {

    @NotEmpty
    @NotNull
    private String uid;
    private Date date;
    private ArrayList<DiaryPageGetResponseModel> diaryPageGetResponseModels;
    private Integer pageCount;

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

    public ArrayList<DiaryPageGetResponseModel> getDiaryPageGetResponseModels() {
        return diaryPageGetResponseModels;
    }

    public void setDiaryPageGetResponseModels(ArrayList<DiaryPageGetResponseModel> diaryPageGetResponseModels) {
        this.diaryPageGetResponseModels = diaryPageGetResponseModels;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    @Override
    public String toString() {
        return "DiaryPageGetResponse{" +
                "uid='" + uid + '\'' +
                ", date=" + date +
                ", diaryPageGetResponseModels=" + diaryPageGetResponseModels +
                ", pageCount=" + pageCount +
                '}';
    }
}
