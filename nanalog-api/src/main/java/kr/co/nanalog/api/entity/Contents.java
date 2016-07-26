package kr.co.nanalog.api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by choijinjoo on 2016. 7. 26..
 */
@Entity
@Table(name = "contents_tb")
public class Contents {
    @Id
    @GeneratedValue
    private long id;
    private String boardId;
    private String componentId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBoardId() {
        return boardId;
    }

    public void setBoardId(String boardId) {
        this.boardId = boardId;
    }

    public String getComponentId() {
        return componentId;
    }

    public void setComponentId(String componentId) {
        this.componentId = componentId;
    }

    @Override
    public String toString() {
        return "Contents{" +
                "id=" + id +
                ", boardId='" + boardId + '\'' +
                ", componentId='" + componentId + '\'' +
                '}';
    }
}
