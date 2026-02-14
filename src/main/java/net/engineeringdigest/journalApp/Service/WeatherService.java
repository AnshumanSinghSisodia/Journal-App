package net.engineeringdigest.journalApp.Service;

import net.engineeringdigest.journalApp.Cache.AppCache;
import net.engineeringdigest.journalApp.api.response.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherService {

    @Value("${weather.api.key}")
    private String apiKey;

   // private static final String api="https://api.weatherstack.com/current?access_key=apiKey&query=CITY";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AppCache appCache;

    public WeatherResponse getWeather(String city){
        String finalApi = appCache.APP_CACHE.get("weather_api").replace("<city>",city).replace("<apiKey>",apiKey);
        ResponseEntity<WeatherResponse> resp = restTemplate.exchange(finalApi, HttpMethod.GET,null, WeatherResponse.class);
        WeatherResponse body = resp.getBody();
        return body;// ..

    }
}
