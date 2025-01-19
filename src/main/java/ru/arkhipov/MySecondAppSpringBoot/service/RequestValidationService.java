package ru.arkhipov.MySecondAppSpringBoot.service;


import ru.arkhipov.MySecondAppSpringBoot.exception.UnsupportedCodeException;
import ru.arkhipov.MySecondAppSpringBoot.exception.ValidationFailedException;
import ru.arkhipov.MySecondAppSpringBoot.model.Request;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;


@Service
public class RequestValidationService implements ValidationService {
    @Override
    public void isValid(BindingResult bindingResult) throws ValidationFailedException, UnsupportedCodeException {
        if (bindingResult.hasErrors()) {
            throw new ValidationFailedException(bindingResult.getFieldError().toString());
        }
    }

    @Override
    public void isCodeValid(Request request) throws UnsupportedCodeException {
        if (!request.isUidValid()) {
            throw new UnsupportedCodeException("uid не может быть равен 123");
        }
    }
}
