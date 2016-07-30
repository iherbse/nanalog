package kr.co.nanalog.api.web.util.service;

import kr.co.nanalog.api.web.util.model.request.DateRequest;
import kr.co.nanalog.api.web.util.model.request.YearAgoDateRequest;
import kr.co.nanalog.api.web.util.model.respnose.DateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 1002731 on 2016. 7. 31..
 * Email : eenan@sk.com
 */
@Service
public class UtilServiceImpl implements UtilService {

    @Autowired
    private DateService dateService;
    @Autowired
    private WeatherService weatherService;
    @Autowired
    private RandomColorServiceImpl randomColorService;

    @Override
    public DateResponse getCurrent(DateRequest dateRequest) {
        return dateService.getCurrent(dateRequest);
    }

    @Override
    public DateResponse getYearAgoDate(YearAgoDateRequest dateRequest) {
        return dateService.getYearAgoDate(dateRequest);
    }

    @Override
    public String chosenColor(String wantedColor) {
        return randomColorService.chosenColor(wantedColor);
    }

    @Override
    public String getWeather(String city, String country, String village) {
        return weatherService.getWeather(city, country, village);
    }
}
