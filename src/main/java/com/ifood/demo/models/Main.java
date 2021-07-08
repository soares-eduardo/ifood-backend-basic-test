package com.ifood.demo.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Main {

    private int pressure;
    private double temp;

    @JsonProperty(value = "temp_min")
    private double tempMin;

    @JsonProperty(value = "temp_max")
    private double tempMax;

    @JsonProperty(value = "feels_like")
    private double feelsLike;

    public double getTemp() {
        return temp;
    }

    public int getPressure() {
        return pressure;
    }

    public double getTempMin() {
        return tempMin;
    }

    public double getTempMax() {
        return tempMax;
    }

    public double getFeelsLike() {
        return feelsLike;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
