package com.example.demo.exception;

public class EntityNotFoundException extends RuntimeException{

    public EntityNotFoundException(String msg) { super(msg);}

    EntityNotFoundException(String msg, Throwable t) {super(msg, t);}

}
