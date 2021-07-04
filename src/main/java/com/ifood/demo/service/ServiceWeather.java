package com.ifood.demo.service;

import com.ifood.demo.models.OpenWeather;
import com.ifood.demo.models.Weather;
import com.ifood.demo.repository.RepositoryWeather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceWeather {

    @Autowired
    RepositoryWeather weatherRepository;

    public String getWeather(String city) {

        OpenWeather openWeather = weatherRepository.getWeatherByCity(city);

        return formatWeather(openWeather);
    }

    public static String formatWeather(OpenWeather openWeather) {

        String description = "";

        for (Weather weather : openWeather.getWeather()) {
            description += "\n" + weather.getDescription();
        }

        String details = "\nTemp: " + openWeather.getMain().getTemp() + "\n" + 
                         "Pressure: " + openWeather.getMain().getPressure();

        return openWeather.getName() + description + details;
    }
}
