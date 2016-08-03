package kr.co.nanalog.api.web.diary.model.request;

import javax.validation.constraints.NotNull;

/**
 * Created by JUNG on 2016. 7. 28..
 */
public class DiaryPageCreateRequest {
    private Long pageId;
    private String userId;
    @NotNull
    private String createdDate;

    public Long getPageId() {
        return pageId;
    }

    public void setPageId(Long pageId) {
        this.pageId = pageId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "DiaryPageCreateRequest{" +
                "pageId=" + pageId +
                ", userId='" + userId + '\'' +
                ", createDate" + createdDate +
                '}';
    }
}
