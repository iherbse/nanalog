package kr.co.nanalog.api.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by lcw on 7/26/16.
 */
@Entity
@Table(name = "diary_db")
public class Diary {

    @Id
    @GeneratedValue
    private long diaryId;
    @Column(nullable = false)
    private String userId;
    private Date createdDate;

    public long getDiaryId() {
        return diaryId;
    }

    public void setDiaryId(long diaryId) {
        this.diaryId = diaryId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "Diary{" +
                "diaryId=" + diaryId +
                ", userId='" + userId + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }
}
