package kr.co.nanalog.api.entity;

<<<<<<< HEAD
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
=======
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
>>>>>>> 2b2cac085904f5e8f23269064679bec41e7eac93
        this.componentId = componentId;
    }

    @Override
    public String toString() {
        return "Contents{" +
<<<<<<< HEAD
                "id=" + id +
                ", boardId='" + boardId + '\'' +
                ", componentId='" + componentId + '\'' +
=======
                "contentsId=" + contentsId +
                ", boardId=" + boardId +
                ", componentId=" + componentId +
>>>>>>> 2b2cac085904f5e8f23269064679bec41e7eac93
                '}';
    }
}
