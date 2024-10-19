package com.nketu.journal.service;

import com.nketu.journal.api.response.WeatherResponse;
import com.nketu.journal.cache.AppCache;
import com.nketu.journal.constants.Placeholders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

//    https://api.weatherstack.com/current?access_key=8047318078042cc24a2c584b91ec81ed&query=Mumbai

    @Value("${weather.api-key}")
    private  String API_KEY;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AppCache appCache;

    @Autowired
    private RedisService redisService;

    public WeatherResponse getWeather(String city){
        WeatherResponse weatherResponse = redisService.get("weather_of_"+city,WeatherResponse.class);
        if (weatherResponse!=null){
            return weatherResponse;
        }
        else{

            String finalApi = appCache.appCacheMap.get(AppCache.keys.WEATHER_API.toString()).replace(Placeholders.API_KEY,API_KEY).replace(Placeholders.LOCATION,city);
            ResponseEntity<WeatherResponse> response = restTemplate.exchange(finalApi, HttpMethod.GET, null, WeatherResponse.class);
            WeatherResponse body = response.getBody();
            if (body!=null){
                redisService.set("weather_of_"+city,body,300L);
            }
            return body;
        }
    }
}
