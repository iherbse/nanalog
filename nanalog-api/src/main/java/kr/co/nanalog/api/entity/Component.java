package kr.co.nanalog.api.entity;


import javax.persistence.*;

/**
 * Created by lcw on 7/26/16.
 */

@Entity
@Table(name = "component_db")
public class Component {
    // 정의 요망
    private enum ComponentType {SENTENCE, IMAGE;}
    // 정의 요망
    private enum ComponentPreference {TOP, MID, BOTTOM;}

    @Id
    @GeneratedValue
    private Long componentId;
    @Column(nullable = false)
    private ComponentType componentType;
    @Column(nullable = false)
    private ComponentPreference componentPreference;

    public Long getComponentId() {
        return componentId;
    }

    public void setComponentId(Long componentId) {
        this.componentId = componentId;
    }

    public ComponentType getComponentType() {
        return componentType;
    }

    public void setComponentType(ComponentType componentType) {
        this.componentType = componentType;
    }

    public ComponentPreference getComponentPreference() {
        return componentPreference;
    }

    public void setComponentPreference(ComponentPreference componentPreference) {
        this.componentPreference = componentPreference;
    }

    @Override
    public String toString() {
        return "Component{" +
                "componentId=" + componentId +
                ", componentType=" + componentType +
                ", componentPreference=" + componentPreference +
                '}';
    }
}
