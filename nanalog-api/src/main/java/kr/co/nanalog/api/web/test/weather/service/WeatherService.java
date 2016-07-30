package kr.co.nanalog.api.web.test.weather.service;

import kr.co.nanalog.api.web.test.weather.model.response.WeatherResponse;

/**
 * Created by Leegain on 2016-07-30.
 */
public interface WeatherService {
    public WeatherResponse getWeather(String city, String country, String village);
}
