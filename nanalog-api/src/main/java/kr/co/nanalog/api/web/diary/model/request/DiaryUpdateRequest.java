package kr.co.nanalog.api.web.diary.model.request;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * Created by choijinjoo on 2016. 7. 30..
 */
public class DiaryUpdateRequest {
    @NotNull
    @NotEmpty
    Long diaryId;

    String diaryOption;

    public Long getDiaryId() {
        return diaryId;
    }

    public void setDiaryId(Long diaryId) {
        this.diaryId = diaryId;
    }
}

