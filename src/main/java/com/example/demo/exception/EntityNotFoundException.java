package com.example.demo.exception;

public class EntityNotFoundException extends Exception{

    EntityNotFoundException(String msg) { super(msg);}
    EntityNotFoundException(String msg, Throwable t) {super(msg, t);}

}
