package kr.co.nanalog.api.web.test.weather.controller;

import kr.co.nanalog.api.web.test.weather.model.request.WeatherRequest;
import kr.co.nanalog.api.web.test.weather.model.response.WeatherResponse;
import kr.co.nanalog.api.web.test.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by Leegain on 2016-07-30.
 */
public class WeatherCotroller {
    @Autowired
    private WeatherService weatherService;

    @RequestMapping(value="/test", method= RequestMethod.GET)
    public WeatherResponse readWeather(@Valid WeatherRequest weatherRequest) {

        WeatherResponse weatherResponse = weatherService.getWeather(weatherRequest.getCity(),
                weatherRequest.getCountry(), weatherRequest.getVillage());

        return weatherResponse;
    }
}
