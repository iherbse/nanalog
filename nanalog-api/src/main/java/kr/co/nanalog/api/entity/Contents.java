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
    private Long contentsId;
    @Column(nullable = false)
    private Long boardId;
    @Column(nullable = false)
    private Long componentId;

    public Long getContentsId() {
        return contentsId;
    }

    public void setContentsId(Long contentsId) {
        this.contentsId = contentsId;
    }

    public Long getBoardId() {
        return boardId;
    }

    public void setBoardId(Long boardId) {
        this.boardId = boardId;
    }

    public Long getComponentId() {
        return componentId;
    }

    public void setComponentId(Long componentId) {
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
