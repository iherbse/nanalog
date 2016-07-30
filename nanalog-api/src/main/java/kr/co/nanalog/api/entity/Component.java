package kr.co.nanalog.api.entity;


import javax.persistence.*;

/**
 * Created by lcw on 7/26/16.
 */
@Entity
@Table(name = "component_tb")
public class Component {

    @Id
    @GeneratedValue
    private Long componentId;
    @Column(nullable = false)
    private Long pageId;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ComponentType componentType;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ComponentPosition componentPosition;
    @Column(nullable = false)
    private String componentData;

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

    public ComponentType getComponentType() {
        return componentType;
    }

    public void setComponentType(ComponentType componentType) {
        this.componentType = componentType;
    }

    public ComponentPosition getComponentPosition() {
        return componentPosition;
    }

    public void setComponentPosition(ComponentPosition componentPosition) {
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
        return "Component{" +
                "componentId=" + componentId +
                ", pageId=" + pageId +
                ", componentType=" + componentType +
                ", componentPosition=" + componentPosition +
                ", componentData='" + componentData + '\'' +
                '}';
    }

    public enum ComponentPosition {
        TOP,
        MID,
        BOTTOM;
    }

    public enum ComponentType {
        TITLE,
        SENTENCE,
        IMAGE;
    }
}
