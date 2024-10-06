package com.nketu.journal.service;

import com.nketu.journal.api.response.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherService {

//    https://api.weatherstack.com/current?access_key=8047318078042cc24a2c584b91ec81ed&query=Mumbai

    private static final String API_KEY ="8047318078042cc24a2c584b91ec81ed";

    private static final String api = "https://api.weatherstack.com/current?access_key=api_key&query=location";

    @Autowired
    private RestTemplate restTemplate;

    public WeatherResponse getWeather(String city){
        String finalApi = api.replace("api_key",API_KEY).replace("location",city);
        ResponseEntity<WeatherResponse> response = restTemplate.exchange(finalApi, HttpMethod.GET, null, WeatherResponse.class);
        WeatherResponse body = response.getBody();
        return body;
    }
}
