package kr.co.nanalog.api.web.diary.model.request;

import kr.co.nanalog.api.web.diary.model.entity.Component;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

/**
 * Created by choijinjoo on 2016. 7. 31..
 */
public class DiaryUpdateRequest {

    @NotNull
    Long pageId;
    @NotNull
    Long componentId;
    @Enumerated(EnumType.STRING)
    private Component.ComponentPosition componentPosition;
    private String componentData;

    public Long getPageId() {
        return pageId;
    }

    public void setPageId(Long pageId) {
        this.pageId = pageId;
    }

    public Long getComponentId() {
        return componentId;
    }

    public void setComponentId(Long componentId) {
        this.componentId = componentId;
    }

    public Component.ComponentPosition getComponentPosition() {
        return componentPosition;
    }

    public void setComponentPosition(Component.ComponentPosition componentPosition) {
        this.componentPosition = componentPosition;
    }

    public String getComponentData() {
        return componentData;
    }

    public void setComponentData(String componentData) {
        this.componentData = componentData;
    }
}
