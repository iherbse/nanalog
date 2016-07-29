package kr.co.nanalog.api.web.diary.model.response;

import kr.co.nanalog.api.entity.Component;

import java.util.ArrayList;

/**
 * Created by lcw on 7/29/16.
 */
public class DiaryViewResponse {
    private ArrayList<Component> components;

    public DiaryViewResponse() {
        components = new ArrayList<>();
    }

    public ArrayList<Component> getComponents() {
        return components;
    }


    public void setComponents(ArrayList<Component> components) {
        this.components = components;
    }

    @Override
    public String toString() {
        return "DiaryViewResponse{" +
                "components=" + components +
                '}';
    }
}
