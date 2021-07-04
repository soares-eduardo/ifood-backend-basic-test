package com.ifood.demo.controllers;

import com.ifood.demo.models.OpenWeather;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/weather")
public class ControllerWeather {

    @Value("${api.key}")
    private String apiKey;

    final String URL = "https://api.openweathermap.org/data/2.5/weather";

    @GetMapping(value = "/{city}")
    public OpenWeather getWeatherByCity(@PathVariable String city) {

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<OpenWeather> weather = restTemplate.getForEntity(URL + "?appid=" + apiKey + "&q=" + city,
                OpenWeather.class);

        return weather.getBody();
    }
}