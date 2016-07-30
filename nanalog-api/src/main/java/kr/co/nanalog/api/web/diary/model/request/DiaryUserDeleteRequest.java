package kr.co.nanalog.api.web.diary.model.request;

/**
 * Created by Leegain on 2016-07-30.
 */
public class DiaryUserDeleteRequest {
    String uid;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        uid = uid;
    }

    @Override
    public String toString() {
        return "DiaryUserDeleteRequst{" +
                "uid='" + uid + '\'' +
                '}';
    }
}
