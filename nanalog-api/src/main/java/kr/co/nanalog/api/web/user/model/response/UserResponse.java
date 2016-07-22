package kr.co.nanalog.api.web.user.model.response;

/**
 * Created by 1002731 on 2016. 7. 22..
 * Email : eenan@sk.com
 */
public class UserResponse {

    private long id;
    private String uid;
    private String name;
    private String registrationDate;
    private String permission;
    private boolean active;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "UserResponse{" +
                "id=" + id +
                ", uid='" + uid + '\'' +
                ", name='" + name + '\'' +
                ", registrationDate='" + registrationDate + '\'' +
                ", permission='" + permission + '\'' +
                ", active=" + active +
                '}';
    }
}
