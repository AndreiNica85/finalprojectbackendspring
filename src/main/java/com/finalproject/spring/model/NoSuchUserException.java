package com.finalproject.spring.model;

public class NoSuchUserException extends Exception{

    public NoSuchUserException(String message) {
        super(message);
    }
}
