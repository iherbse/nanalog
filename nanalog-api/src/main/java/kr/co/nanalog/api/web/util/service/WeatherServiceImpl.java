package kr.co.nanalog.api.web.util.service;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Leegain on 2016-07-30.
 */
@Service
public class WeatherServiceImpl implements WeatherService {

    private static String API_HOSTNAME = "http://apis.skplanetx.com/weather";
    private static String APP_KEY = "0f97a295-2781-30fe-8741-13a2ad1102bb";
    private static String NULL_RESULT = "몰라요";

    @Override
    public String getWeather(String city, String country, String village) {

        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> jsonresult = null;

        String serverUrl = API_HOSTNAME + "/current/hourly?city={city}&county={country}&village={village}&version={version}";

        Map<String, Object> params = new HashMap<>();
        params.put("city", city);
        params.put("country", country);
        params.put("village", village);
        params.put("version", "1");

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("appKey",APP_KEY);

        HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<String> response = restTemplate.exchange(serverUrl, HttpMethod.GET, httpEntity,String.class,params);

        String result = response.getBody();

        try {
            TypeReference<HashMap<String, Object>> typeRef = new TypeReference<HashMap<String, Object>>(){};
            Map<String, Map<String, ArrayList<HashMap<String, HashMap<String, String>>>>> o = objectMapper.readValue(result, typeRef);
            String weatherName = o.get("weather").get("hourly").get(0).get("sky").get("name");

            return weatherName;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return NULL_RESULT;
    }
}
