package kr.co.nanalog.api.web.util.service;

import org.springframework.stereotype.Service;

/**
 * Created by lcw on 7/17/16.
 */
@Service
public class RandomColorServiceImpl implements RandomColorService{

    public String chosenColor(String wantedColor) {
        String colorCode = "#";
        if (wantedColor != null && !wantedColor.equals("")) {
            for (int i = 1; i < 7; i++) {
                String valuableCharacter = wantedColor.charAt(i) + "";
                if (valuableCharacter.matches("([0-9A-Fa-f])")) {
                    colorCode += valuableCharacter.toUpperCase();
                } else {
                    int order = (int) (Math.random() * 16);
                    colorCode += Integer.toHexString(order).toUpperCase();
                }

            }
        }

        return colorCode;
    }
}
