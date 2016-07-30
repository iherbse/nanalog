package kr.co.nanalog.api.web.diary.model.response;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by lcw on 7/29/16.
 */
public class DiaryComponentGetResponse {
    @NotEmpty
    @NotNull
    private String uid;
    @NotEmpty
    @NotNull
    private Long pageId;
    private List<DiaryComponentGetResponseModel> diaryComponentGetResponseModels;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Long getPageId() {
        return pageId;
    }

    public void setPageId(Long pageId) {
        this.pageId = pageId;
    }

    public List<DiaryComponentGetResponseModel> getDiaryComponentGetResponseModels() {
        return diaryComponentGetResponseModels;
    }

    public void setDiaryComponentGetResponseModels(List<DiaryComponentGetResponseModel> diaryComponentGetResponseModels) {
        this.diaryComponentGetResponseModels = diaryComponentGetResponseModels;
    }

    @Override
    public String toString() {
        return "DiaryComponentGetResponse{" +
                "uid='" + uid + '\'' +
                ", pageId=" + pageId +
                ", diaryComponentGetResponseModels=" + diaryComponentGetResponseModels +
                '}';
    }
}
