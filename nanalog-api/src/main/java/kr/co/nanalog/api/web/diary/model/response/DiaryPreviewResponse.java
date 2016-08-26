package kr.co.nanalog.api.web.diary.model.response;

/**
 * Created by choijinjoo on 2016. 8. 14..
 */
public class DiaryPreviewResponse {
    private String uid;
    private String pid;
    private String date;
    private String title;
    private String body;
    private String imageUrl;

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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "DiaryPreviewResponse{" +
                "uid='" + uid + '\'' +
                ", pid='" + pid + '\'' +
                ", date='" + date + '\'' +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
