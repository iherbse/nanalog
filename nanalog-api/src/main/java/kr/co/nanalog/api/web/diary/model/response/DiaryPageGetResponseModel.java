package kr.co.nanalog.api.web.diary.model.response;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by lcw on 7/30/16.
 */
public class DiaryPageGetResponseModel {

    @NotNull
    @NotEmpty
    private Long pageId;
    @NotNull
    @NotEmpty
    private String createdDate;
    private String modifiedDate;

    public Long getPageId() {
        return pageId;
    }

    public void setPageId(Long pageId) {
        this.pageId = pageId;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
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
