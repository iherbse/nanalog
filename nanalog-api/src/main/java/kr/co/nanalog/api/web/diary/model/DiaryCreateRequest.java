package kr.co.nanalog.api.web.diary.model;

/**
 * Created by choijinjoo on 2016. 8. 14..
 */
public class DiaryCreateRequest {
    private String uid;
    private String date;
    private String type;
    private String data;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "DiaryCreateRequest{" +
                "uid='" + uid + '\'' +
                ", date='" + date + '\'' +
                ", type='" + type + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
