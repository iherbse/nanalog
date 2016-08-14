package kr.co.nanalog.api.web.diary.model.response;

/**
 * Created by choijinjoo on 2016. 8. 14..
 */
public class DiaryPreviewResponse {
    private String uid;
    private String pid;
    private String date;
    private String type;
    private String title;
    private String body;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "DiaryPreviewResponse{" +
                "uid='" + uid + '\'' +
                ", pid='" + pid + '\'' +
                ", date='" + date + '\'' +
                ", type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
