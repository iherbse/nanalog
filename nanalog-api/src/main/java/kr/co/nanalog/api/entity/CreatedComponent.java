package kr.co.nanalog.api.entity;


import javax.persistence.*;
import java.util.Date;

/**
 * Created by lcw on 7/26/16.
 */
@Entity
@Table(name = "createdComponent_db")
public class CreatedComponent {

    @Id
    @GeneratedValue
    private Long createdComponentId;
    @Column(nullable = false)
    private Long componentId;
    private String componentData;
    private Long boardId;
    @Column(nullable = false)
    private Date createdDate;
    private Date modifiedDate;

    public Long getCreatedComponentId() {
        return createdComponentId;
    }

    public void setCreatedComponentId(Long createdComponentId) {
        this.createdComponentId = createdComponentId;
    }

    public Long getComponentId() {
        return componentId;
    }

    public void setComponentId(Long componentId) {
        this.componentId = componentId;
    }

    public String getComponentData() {
        return componentData;
    }

    public void setComponentData(String componentData) {
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

    public Long getBoardId() {
        return boardId;
    }

    public void setBoardId(Long boardId) {
        this.boardId = boardId;
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
