package kr.co.nanalog.test.color.model.respnose;

/**
 * Created by lcw on 7/17/16.
 */
public class RandomColorResponse {
    private String randomColor;

    public String getRandomColor() {
        return randomColor;
    }

    public void setRandomColor(String randomColor) {
        this.randomColor = randomColor;
    }

    @Override
    public String toString() {
        return "RandomColorResponse{" +
                "randomColor='" + randomColor + '\'' +
                '}';
    }
}
