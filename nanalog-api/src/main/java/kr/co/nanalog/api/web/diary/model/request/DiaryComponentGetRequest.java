package kr.co.nanalog.api.web.diary.model.request;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * Created by lcw on 7/29/16.
 */
public class DiaryComponentGetRequest {

    @NotEmpty
    @NotNull
    private String uid;
    @NotEmpty
    @NotNull
    private String pageId;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPageId() {
        return pageId;
    }

    public void setPageId(String pageId) {
        this.pageId = pageId;
    }

    @Override
    public String toString() {
        return "DiaryComponentGetRequest{" +
                "uid='" + uid + '\'' +
                ", pageId='" + pageId + '\'' +
                '}';
    }
}
