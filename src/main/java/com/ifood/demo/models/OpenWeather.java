package com.ifood.demo.models;

import java.util.List;

public class OpenWeather {

    //temperatura, pressão, ensolarado, nublado
    
    private String name;
    private Main main;
    private List<Weather> weather;

    public String getName() {
        return name;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public Main getMain() {
        return main;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}
