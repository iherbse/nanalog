package kr.co.nanalog.api.web.diary.model.request;

import kr.co.nanalog.api.entity.Component;
import kr.co.nanalog.api.entity.Diary;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;

/**
 * Created by choijinjoo on 2016. 7. 30..
 */
public class DiaryPageUpdateRequest {
    @NotNull
    @NotEmpty
    Long pageId;
    ArrayList<Component> components;

    public Long getPageId() {
        return pageId;
    }

    public void setPageId(Long pageId) {
        this.pageId = pageId;
    }

    public ArrayList<Component> getComponents() {
        return components;
    }

    public void setComponents(ArrayList<Component> components) {
        this.components = components;
    }
}

