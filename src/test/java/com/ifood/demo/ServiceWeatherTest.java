package com.ifood.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.ifood.demo.exceptions.NotFoundException;
import com.ifood.demo.models.OpenWeather;
import com.ifood.demo.services.ServiceWeather;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ServiceWeatherTest {

    @Autowired
    private ServiceWeather underTest;

    @Test
    void itShouldReturnCityValues() {

        // given
        String city = "London";
        String country = "GB";
        int id = 2643743;

        // when
        OpenWeather openWeather = underTest.getWeatherByCity(city);

        // then
        assertEquals(city, openWeather.getName());
        assertEquals(id, openWeather.getId());
        assertEquals(country, openWeather.getSys().getCountry());
    }

    @Test
    void itShouldReturnCityNotFoundException() {

        // given
        String city = "non existent city";
        String expectedMessage = "City not found";

        // when
        Exception exception = assertThrows(NotFoundException.class, () -> {
            underTest.getWeatherByCity(city);
        });

        String currentMessage = exception.getMessage();

        // then
        assertTrue(currentMessage.contains(expectedMessage));
    }
}
