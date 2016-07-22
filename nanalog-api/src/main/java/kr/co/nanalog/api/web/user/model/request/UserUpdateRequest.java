package kr.co.nanalog.api.web.user.model.request;

import javax.validation.constraints.NotNull;

/**
 * Created by 1002731 on 2016. 7. 18..
 * Email : eenan@sk.com
 */
public class UserUpdateRequest {

    @NotNull
    private String uid;
    private String name;
    private String password;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserUpdateRequest{" +
                "uid='" + uid + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
