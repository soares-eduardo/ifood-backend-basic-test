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

    public OpenWeather getWeatherByCity(String city) {
 
        String url = "https://api.openweathermap.org/data/2.5/weather?appid=" + apiKey + "&q=" + city;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<OpenWeather> weather = null;

        try {
            weather = restTemplate.getForEntity(url, OpenWeather.class);
        } catch (Exception e) {
            throw new NotFoundException();
        }

        return weather.getBody();
    }
}
