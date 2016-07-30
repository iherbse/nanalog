package kr.co.nanalog.api.web.test.weather.service;

import kr.co.nanalog.api.web.test.weather.model.response.WeatherResponse;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Leegain on 2016-07-30.
 */
public class WeatherServiceImpl implements WeatherService {
    @Override
    public WeatherResponse getWeather(String city, String country, String village) {

        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper objectMapper = new ObjectMapper();
        WeatherResponse weatherResponse = new WeatherResponse();
        Map<String, String> jsonresult = null;

        String serverUrl = "http://apis.skplanetx.com/weather/current/hourly?version={1}&city={city}&county={country}&village={village}&appKey={appKey}";

        Map<String, Object> params = new HashMap<>();
        params.put("city", city);
        params.put("country", country);
        params.put("village", village);
        params.put("appKey","0f97a295-2781-30fe-8741-13a2ad1102bb");


        String result = restTemplate.getForObject(serverUrl, String.class, params);

        /*
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("appKey","0f97a295-2781-30fe-8741-13a2ad1102bb");

        HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);



        ResponseEntity<String> response = restTemplate.exchange(serverUrl, HttpMethod.GET, httpEntity,String.class,params);

        String result = response.getBody();
        */


        try {
            jsonresult = objectMapper.readValue(result, Map.class);
        }catch (IOException e){
            throw new RuntimeException(e);
        }


        weatherResponse.setSky(jsonresult.get("sky"));



        return weatherResponse;

    }
}
