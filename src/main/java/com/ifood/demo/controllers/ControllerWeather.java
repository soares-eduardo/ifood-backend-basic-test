package com.ifood.demo.controllers;

import com.ifood.demo.models.OpenWeather;
import com.ifood.demo.services.ServiceWeather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/weather")
public class ControllerWeather {

    @Autowired
    private ServiceWeather serviceWeather;

    @Cacheable("weather")
    @GetMapping(value = "/{city}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OpenWeather> getWeatherByCity(@PathVariable String city) {
        return ResponseEntity.ok(serviceWeather.getWeatherByCity(city));
    }
}