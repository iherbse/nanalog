package kr.co.nanalog.api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by choijinjoo on 2016. 7. 27..
 */
@Entity
@Table(name = "createdcomponent_tb")
public class CreatedComponent {
    @Id
    @GeneratedValue
    private long id;
    private String createdComponentId;
    private String componentId;
    private String componentData;
    private String createdDate;
    private String modifiedDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCreatedComponentId() {
        return createdComponentId;
    }

    public void setCreatedComponentId(String createdComponentId) {
        this.createdComponentId = createdComponentId;
    }

    public String getComponentId() {
        return componentId;
    }

    public void setComponentId(String componentId) {
        this.componentId = componentId;
    }

    public String getComponentData() {
        return componentData;
    }

    public void setComponentData(String componentData) {
        this.componentData = componentData;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @Override
    public String toString() {
        return "CreatedComponent{" +
                "id=" + id +
                ", createdComponentId='" + createdComponentId + '\'' +
                ", componentId='" + componentId + '\'' +
                ", componentData='" + componentData + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", modifiedDate='" + modifiedDate + '\'' +
                '}';
    }
}
