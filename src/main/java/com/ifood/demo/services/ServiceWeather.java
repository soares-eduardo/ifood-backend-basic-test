package com.ifood.demo.services;

import com.ifood.demo.exceptions.NotFoundException;
import com.ifood.demo.models.OpenWeather;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ServiceWeather {

    @Value("${api.key}")
    private String apiKey;

    private ResponseEntity<OpenWeather> weather;

    public OpenWeather getWeatherByCity(String city) {
 
        String URL = "https://api.openweathermap.org/data/2.5/weather?appid=" + apiKey + "&q=" + city;

        RestTemplate restTemplate = new RestTemplate();

        try {
            weather = restTemplate.getForEntity(URL, OpenWeather.class);
        } catch (Exception e) {
            throw new NotFoundException();
        }

        return weather.getBody();
    }
}
