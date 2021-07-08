package com.ifood.demo.exceptions;

public class NotFoundException extends RuntimeException{

    public NotFoundException() {
        super("City not found");
    }
}
