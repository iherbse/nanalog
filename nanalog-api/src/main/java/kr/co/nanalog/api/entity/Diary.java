package kr.co.nanalog.api.entity;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

import java.util.Date;

/**
 * Created by lcw on 7/26/16.
 */
@Entity
@Table(name = "diary_tb")
public class Diary {

    @Id
    @GeneratedValue
    private Long diaryId;
    @Column(nullable = false)
    private String userId;
    @Column(nullable = false)
    @ColumnDefault("basic")
    private String diaryOption;
    @Column(nullable = false)
    private Date createdDate;

    public Long getDiaryId() {
        return diaryId;
    }

    public void setDiaryId(Long diaryId) {
        this.diaryId = diaryId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDiaryOption() {
        return diaryOption;
    }

    public void setDiaryOption(String diaryOption) {
        this.diaryOption = diaryOption;
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
                ", diaryOption='" + diaryOption + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }
}
