package com.ifood.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/about")
public class ControllerAbout {

    @GetMapping
    public String getAbout() {
        return "It's working";
    }
}
