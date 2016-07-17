package kr.co.nanalog.api.entity;

import javax.persistence.*;

/**
 * Created by 1002731 on 2016. 7. 17..
 * Email : eenan@sk.com
 */
@Entity
@Table(name = "user_tb")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false)
    private String uid;
    private String name;
    @Column(nullable = false)
    private String password;
    private String registrationDate;

    @OneToOne
    @JoinColumn(name = "userStatus_id")
    private UserStatus userStatus;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", uid='" + uid + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", registrationDate='" + registrationDate + '\'' +
                ", userStatus=" + userStatus +
                '}';
    }
}
