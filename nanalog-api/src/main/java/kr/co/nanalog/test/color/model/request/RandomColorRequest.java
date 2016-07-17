package kr.co.nanalog.test.color.model.request;

import javax.validation.constraints.NotNull;

/**
 * Created by lcw on 7/17/16.
 */
public class RandomColorRequest {
    @NotNull
    private String wantedColor;

    public String getWantedColor() {
        return wantedColor;
    }

    public void setWantedColor(String wantedColor) {
        this.wantedColor = wantedColor;
    }

    @Override
    public String toString() {
        return "RandomColorRequest{" +
                "wantedColor='" + wantedColor + '\'' +
                '}';
    }

}
