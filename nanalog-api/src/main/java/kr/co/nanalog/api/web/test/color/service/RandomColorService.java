package kr.co.nanalog.api.web.test.color.service;

import kr.co.nanalog.api.web.test.color.model.respnose.RandomColorResponse;
import org.springframework.stereotype.Service;

/**
 * Created by lcw on 7/17/16.
 */
@Service
public class RandomColorService {

    public RandomColorResponse chosenColor(String wantedColor) {
        RandomColorResponse randomColorResponse = new RandomColorResponse();

        String color = "#";
        if (wantedColor != null && !wantedColor.equals("")) {
            for (int i = 1; i < 7; i++) {
                String valuableCharacter = wantedColor.charAt(i) + "";
                if (valuableCharacter.matches("([0-9A-Fa-f])")) {
                    color += valuableCharacter;
                } else {
                    int order = (int) (Math.random() * 16);
                    color += Integer.toHexString(order).toLowerCase();
                }

            }
        }
        randomColorResponse.setRandomColor(color);
        return randomColorResponse;
    }
}
