package kr.co.nanalog.api.entity;
import javax.persistence.*;
import java.util.Date;

/**
 * Created by lcw on 7/26/16.
 */
@Entity
@Table(name = "board_db")
public class Board {
    @Id
    @GeneratedValue
    private Long boardId;
    @Column(nullable = false)
    private Long diaryId;
    private Date createdDate;

    public Long getBoardId() {
        return boardId;
    }

    public void setBoardId(Long boardId) {
        this.boardId = boardId;
    }

    public Long getDiaryId() {
        return diaryId;
    }

    public void setDiaryId(Long diaryId) {
        this.diaryId = diaryId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "Board{" +
                "boardId=" + boardId +
                ", diaryId=" + diaryId +
                ", createdDate=" + createdDate +
                '}';
    }
}
