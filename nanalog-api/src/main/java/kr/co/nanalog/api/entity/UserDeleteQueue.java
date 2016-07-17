package kr.co.nanalog.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by 1002731 on 2016. 7. 17..
 * Email : eenan@sk.com
 */
@Entity
public class UserDeleteQueue {
    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false)
    private String uid;
    @Column(nullable = false)
    private String deleteDate;

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

    public String getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(String deleteDate) {
        this.deleteDate = deleteDate;
    }

    @Override
    public String toString() {
        return "UserDeleteQueue{" +
                "id=" + id +
                ", uid='" + uid + '\'' +
                ", deleteDate='" + deleteDate + '\'' +
                '}';
    }
}
