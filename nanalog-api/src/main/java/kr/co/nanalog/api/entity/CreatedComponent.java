package kr.co.nanalog.api.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by lcw on 7/26/16.
 */
@Entity
@Table(name = "createdComponent_db")
public class CreatedComponent<T> {

    @Id
    @GeneratedValue
    private long createdComponentId;
    @Column(nullable = false)
    private long componentId;
    private T componentData;
    @Column(nullable = false)
    private Date createdDate;
    private Date modifiedDate;

    public long getCreatedComponentId() {
        return createdComponentId;
    }

    public void setCreatedComponentId(long createdComponentId) {
        this.createdComponentId = createdComponentId;
    }

    public long getComponentId() {
        return componentId;
    }

    public void setComponentId(long componentId) {
        this.componentId = componentId;
    }

    public T getComponentData() {
        return componentData;
    }

    public void setComponentData(T componentData) {
        this.componentData = componentData;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @Override
    public String toString() {
        return "CreatedComponent{" +
                "createdComponentId=" + createdComponentId +
                ", componentId=" + componentId +
                ", componentData='" + componentData + '\'' +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                '}';
    }
}
