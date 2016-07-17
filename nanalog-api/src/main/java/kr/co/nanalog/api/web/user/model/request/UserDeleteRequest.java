package kr.co.nanalog.api.web.user.model.request;

/**
 * Created by 1002731 on 2016. 7. 18..
 * Email : eenan@sk.com
 */
public class UserDeleteRequest {

    private String uid;
    private String password;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserDeleteRequest{" +
                "uid='" + uid + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
