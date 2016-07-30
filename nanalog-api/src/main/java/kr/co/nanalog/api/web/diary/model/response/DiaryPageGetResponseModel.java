package kr.co.nanalog.api.web.diary.model.response;

import java.util.Date;

/**
 * Created by lcw on 7/30/16.
 */
public class DiaryPageGetResponseModel {

    private Long pageId;
    private Date createdDate;
    private Date modifiedDate;

    public Long getPageId() {
        return pageId;
    }

    public void setPageId(Long pageId) {
        this.pageId = pageId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @Override
    public String toString() {
        return "DiaryPageGetResponseModel{" +
                "pageId=" + pageId +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                '}';
    }
}
