package kr.co.nanalog.api.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by lcw on 7/26/16.
 */
@Entity
@Table(name = "page_tb")
public class Page {
    @Id
    @GeneratedValue
    private Long pageId;
    @Column(nullable = false)
    private String uid;
    @Column(nullable = false)
    private String createdDate;
    private String modifiedDate;

    public Long getPageId() {
        return pageId;
    }

    public void setPageId(Long pageId) {
        this.pageId = pageId;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
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
        return "Page{" +
                "pageId=" + pageId +
                ", uid='" + uid + '\'' +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                '}';
    }
}
