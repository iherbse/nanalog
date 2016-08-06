package kr.co.nanalog.api.web.diary.model.response;

import kr.co.nanalog.api.web.diary.model.entity.Component;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * Created by lcw on 7/30/16.
 */
public class DiaryComponentGetResponseModel {
    @NotNull
    @NotEmpty
    private Long componentId;
    @NotNull
    @NotEmpty
    private Component.ComponentType componentType;
    @NotNull
    @NotEmpty
    private Component.ComponentPosition componentPosition;
    @NotNull
    private String componentData;

    public Long getComponentId() {
        return componentId;
    }

    public void setComponentId(Long componentId) {
        this.componentId = componentId;
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

    public String getComponentData() {
        return componentData;
    }

    public void setComponentData(String componentData) {
        this.componentData = componentData;
    }

    @Override
    public String toString() {
        return "DiaryComponentGetResponseModel{" +
                "componentId=" + componentId +
                ", componentType=" + componentType +
                ", componentPosition=" + componentPosition +
                ", componentData='" + componentData + '\'' +
                '}';
    }
}
