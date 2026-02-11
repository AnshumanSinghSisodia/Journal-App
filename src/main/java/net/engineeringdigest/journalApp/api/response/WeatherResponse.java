package net.engineeringdigest.journalApp.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class WeatherResponse {

//    public Request request;
//    public Location location;
    public Current current;

    @Getter
    @Setter
    public class AirQuality{
        public String co;
        public String no2;
        public String o3;
        public String so2;
        public String pm2_5;
        public String pm10;
        public String usepaindex;
        public String gbdefraindex;
    }

    @Getter
    @Setter
    public class Astro{
        public String sunrise;
        public String sunset;
        public String moonrise;
        public String moonset;
        public String moon_phase;
        public int moon_illumination;
    }


    @Getter
    @Setter
    public class Current{

        public int temperature;

        @JsonProperty("weather_descriptions")     //bcaz we follow camel casin java but response is json with _  good practice.
        public List<String> weatherDescriptions;

        public int feelslike;

    }

//    public class Location{
//        public String name;
//        public String country;
//        public String region;
//        public String lat;
//        public String lon;
//        public String timezone_id;
//        public String localtime;
//        public int localtime_epoch;
//        public String utc_offset;
//    }
//
//    public class Request{
//        public String type;
//        public String query;
//        public String language;
//        public String unit;
//    }



}
