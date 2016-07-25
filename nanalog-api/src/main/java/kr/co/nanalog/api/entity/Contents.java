package kr.co.nanalog.api.entity;

import javax.persistence.*;

/**
 * Created by lcw on 7/26/16.
 */
@Entity
@Table(name = "contents_db")
public class Contents {
    @Id
    @GeneratedValue
    private long contentsId;
    @Column(nullable = false)
    private long boardId;
    @Column(nullable = false)
    private long componentId;

    public long getContentsId() {
        return contentsId;
    }

    public void setContentsId(long contentsId) {
        this.contentsId = contentsId;
    }

    public long getBoardId() {
        return boardId;
    }

    public void setBoardId(long boardId) {
        this.boardId = boardId;
    }

    public long getComponentId() {
        return componentId;
    }

    public void setComponentId(long componentId) {
        this.componentId = componentId;
    }

    @Override
    public String toString() {
        return "Contents{" +
                "contentsId=" + contentsId +
                ", boardId=" + boardId +
                ", componentId=" + componentId +
                '}';
    }
}
