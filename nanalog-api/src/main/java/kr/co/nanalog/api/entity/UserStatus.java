package kr.co.nanalog.api.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by 1002731 on 2016. 7. 17..
 * Email : eenan@sk.com
 */
public class UserStatus {

    @Id
    @GeneratedValue
    private long id;
    private boolean active;
    private String permission;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    @Override
    public String toString() {
        return "UserStatus{" +
                "id=" + id +
                ", active=" + active +
                ", permission='" + permission + '\'' +
                '}';
    }
}
