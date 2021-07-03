package com.ifood.demo.models;

import java.util.List;

public class OpenWeather {

    //temperatura, pressão, ensolarado, nublado
    
    private String name;
    private List<Weather> weather;

    public String getName() {
        return name;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}
