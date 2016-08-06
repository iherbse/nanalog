package kr.co.nanalog.api.web.util;

import kr.co.nanalog.api.web.util.model.request.DateRequest;
import kr.co.nanalog.api.web.util.model.request.WeatherRequest;
import kr.co.nanalog.api.web.util.model.request.YearAgoDateRequest;
import kr.co.nanalog.api.web.util.model.respnose.DateResponse;
import kr.co.nanalog.api.web.util.service.UtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by 1002731 on 2016. 7. 31..
 * Email : eenan@sk.com
 */
@RestController
@RequestMapping("/v1/util")
public class UtilController {

    @Autowired
    private UtilService utilService;

    @RequestMapping(value = "/date/current", method = RequestMethod.GET)
    public DateResponse getCurrentDate(@Valid DateRequest dateRequest) {

        DateResponse dateResponse = this.utilService.getCurrent(dateRequest);
        if (dateResponse.getCode() == 1) return dateResponse;
        else {
            dateResponse.setCode(-1);
            return dateResponse;
        }
    }

    @RequestMapping(value = "/date/yearago", method = RequestMethod.GET)
    public DateResponse getYearAgoDate(@Valid YearAgoDateRequest dateRequest) {

        DateResponse dateResponse = this.utilService.getYearAgoDate(dateRequest);
        if (dateResponse.getCode() == 1) return dateResponse;
        else {
            dateResponse.setCode(-1);
            return dateResponse;
        }
    }

    @RequestMapping(value = "/color/random",method = RequestMethod.GET)
    public String choosenColor(@RequestParam(required=true) String wantedColor){
        return this.utilService.chosenColor(wantedColor);
    }

    @RequestMapping(value = "/weather", method= RequestMethod.GET)
    public String readWeather(@Valid WeatherRequest weatherRequest) {
        return this.utilService.getWeather(weatherRequest.getCity(),
                weatherRequest.getCountry(), weatherRequest.getVillage());
    }
}
