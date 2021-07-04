package com.ifood.demo.repository;

import com.ifood.demo.models.OpenWeather;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RepositoryWeather {

    @Value("${api.key}")
    private String apiKey;

    final String URL = "https://api.openweathermap.org/data/2.5/weather";

    public OpenWeather getWeatherByCity(String city) {

        RestTemplate restTemplate = new RestTemplate();

        System.out.println(URL + "appid=" + apiKey + "&q=" + city);

        ResponseEntity<OpenWeather> weather = restTemplate.getForEntity(URL + "?appid=" + apiKey + "&q=" + city,
                OpenWeather.class);

        return weather.getBody();
    }
}
