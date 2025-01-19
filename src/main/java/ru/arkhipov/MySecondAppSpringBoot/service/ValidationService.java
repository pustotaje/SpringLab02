package ru.arkhipov.MySecondAppSpringBoot.service;


import ru.arkhipov.MySecondAppSpringBoot.exception.UnsupportedCodeException;
import ru.arkhipov.MySecondAppSpringBoot.exception.ValidationFailedException;
import ru.arkhipov.MySecondAppSpringBoot.model.Request;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
public interface ValidationService {
    void isValid(BindingResult bindingResult) throws ValidationFailedException, UnsupportedCodeException;

    void isCodeValid(Request request) throws UnsupportedCodeException;
}