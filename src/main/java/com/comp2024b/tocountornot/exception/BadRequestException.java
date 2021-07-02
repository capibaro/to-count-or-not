package com.comp2024b.tocountornot.exception;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String message) { super(message); }
}
