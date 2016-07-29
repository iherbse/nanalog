package kr.co.nanalog.api.web.diary.model.request;

/**
 * Created by lcw on 7/29/16.
 */
public class DiaryViewRequest {
    private Long pageId;

    public Long getPageId() {
        return pageId;
    }

    public void setPageId(Long pageId) {
        this.pageId = pageId;
    }

    @Override
    public String toString() {
        return "DiaryViewRequest{" +
                "pageId=" + pageId +
                '}';
    }
}
