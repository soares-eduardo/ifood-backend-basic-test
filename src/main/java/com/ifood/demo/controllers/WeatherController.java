package com.ifood.demo.controllers;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/weather")
public class WeatherController {

    // https://api.openweathermap.org/data/2.5/weather?q=london&appid=3fc953bc2f573dcaa53afb899851eb3a
    final String URL = "https://api.openweathermap.org/data/2.5/weather?q=";
    final String API_KEY = "3fc953bc2f573dcaa53afb899851eb3a";

    @GetMapping(value = "/{city}")
    public String getWeatherByCity(@PathVariable String city) {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(URL + city + "&appid=" + API_KEY)).build();
        HttpResponse<String> response = null;

        System.out.println(request);

        try {
            response = client.send(request, BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return response.body();
    }
}