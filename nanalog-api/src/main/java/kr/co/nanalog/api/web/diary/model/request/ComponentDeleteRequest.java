package kr.co.nanalog.api.web.diary.model.request;

/**
 * Created by Leegain on 2016-07-30.
 */
public class ComponentDeleteRequest {


    public String userId;
    public Long componentId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getComponentId() {
        return componentId;
    }

    public void setComponentId(Long componentId) {
        this.componentId = componentId;
    }

    @Override
    public String toString() {
        return "ComponentDeleteRequest{" +
                "userId='" + userId + '\'' +
                ", componentId=" + componentId +
                '}';
    }
}
