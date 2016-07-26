package kr.co.nanalog.api.entity;

import javax.persistence.*;

/**
 * Created by choijinjoo on 2016. 7. 26..
 */
@Entity
@Table(name = "diary_tb")
public class Diary {
    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false)
    private String uid;
    private String createdAt;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Diary{" +
                "id=" + id +
                ", uid='" + uid + '\'' +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}
