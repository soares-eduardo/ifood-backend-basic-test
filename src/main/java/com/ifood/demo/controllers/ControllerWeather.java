package com.ifood.demo.controllers;

import com.ifood.demo.service.ServiceWeather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/weather")
public class ControllerWeather {

    @Autowired
    ServiceWeather weatherService;

    @GetMapping(value = "/{city}")
    public String getWeatherByCity(@PathVariable String city) {
        return weatherService.getWeather(city);
    }
}