package net.engineeringdigest.journalApp.Service;

import net.engineeringdigest.journalApp.api.response.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherService {
    private static final String apiKey="2345923790b1b303fe365bdac979dc3d";

    private static final String api="https://api.weatherstack.com/current?access_key=apiKey&query=CITY";

    @Autowired
    private RestTemplate restTemplate;

    public WeatherResponse getWeather(String city){
        String finalApi = api.replace("CITY",city).replace("apiKey",apiKey);
        ResponseEntity<WeatherResponse> resp = restTemplate.exchange(finalApi, HttpMethod.GET,null, WeatherResponse.class);
        WeatherResponse body = resp.getBody();
        return body;

    }
}
