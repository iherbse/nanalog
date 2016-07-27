package kr.co.nanalog.api.web.diary.model.response;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by lcw on 7/26/16.
 */
public class DiaryListResponse {

    private Long boardId;
    private Long diaryId;
    private ArrayList<Date> createdDate;

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

    public ArrayList<Date> getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(ArrayList<Date> createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "DiaryListResponse{" +
                "boardId=" + boardId +
                ", diaryId=" + diaryId +
                ", createdDate=" + createdDate +
                '}';
    }
}
