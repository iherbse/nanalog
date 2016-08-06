package kr.co.nanalog.api.web.diary.model.request;

import kr.co.nanalog.api.web.diary.model.entity.Component;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

/**
 * Created by JUNG on 2016. 8. 1 ..
 */
public class ComponentCreateRequest {
    private Long componentId;
    public Long pageId;
    @NotNull
    private String componentDate;
    @Enumerated(EnumType.STRING)
    private Component.ComponentType componentType;
    @Enumerated(EnumType.STRING)
    private Component.ComponentPosition componentPosition;

    public Long getComponentId() {
        return componentId;
    }

    public void setComponentId(Long componentId) {
        this.componentId = componentId;
    }

    public Long getPageId() {
        return pageId;
    }

    public void setPageId(Long pageId) {
        this.pageId = pageId;
    }

    public String getComponentDate() {
        return componentDate;
    }

    public void setComponentDate(String componentDate) {
        this.componentDate = componentDate;
    }

    public Component.ComponentType getComponentType() {
        return componentType;
    }

    public void setComponentType(Component.ComponentType componentType) {
        this.componentType = componentType;
    }

    public Component.ComponentPosition getComponentPosition() {
        return componentPosition;
    }

    public void setComponentPosition(Component.ComponentPosition componentPosition) {
        this.componentPosition = componentPosition;
    }

}
