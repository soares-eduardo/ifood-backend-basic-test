package com.ifood.demo.models;

import java.util.List;

public class OpenWeather {

    //temperatura, pressão, ensolarado, nublado
    
    private String name;
    private Sys sys;
    private Main main;
    private List<Weather> weather;

    public String getName() {
        return name;
    }

    public Sys getSys() {
        return sys;
    }

    public Main getMain() {
        return main;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
