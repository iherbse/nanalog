package kr.co.nanalog.api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by choijinjoo on 2016. 7. 26..
 */
@Entity
@Table(name = "board_tb")
public class Board {

    @Id
    @GeneratedValue
    private long id;
    private String boardId;
    private String diaryId;
    private String createdDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBoardId() {
        return boardId;
    }

    public void setBoardId(String boardId) {
        this.boardId = boardId;
    }

    public String getDiaryId() {
        return diaryId;
    }

    public void setDiaryId(String diaryId) {
        this.diaryId = diaryId;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "Board{" +
                "id=" + id +
                ", boardId='" + boardId + '\'' +
                ", diaryId='" + diaryId + '\'' +
                ", createdDate='" + createdDate + '\'' +
                '}';
    }
}
