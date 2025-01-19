package ru.arkhipov.MySecondAppSpringBoot.exception;

public class ValidationFailedException extends Exception {
    public ValidationFailedException(String message) { super(message);}
}