package ru.arkhipov.MySecondAppSpringBoot.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import ru.arkhipov.MySecondAppSpringBoot.exception.UnsupportedCodeException;
import ru.arkhipov.MySecondAppSpringBoot.exception.ValidationFailedException;
import ru.arkhipov.MySecondAppSpringBoot.model.*;
import ru.arkhipov.MySecondAppSpringBoot.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.arkhipov.MySecondAppSpringBoot.util.DateTimeUtil;
import java.util.Date;

@Slf4j
@RestController
public class MyController {

    private final ValidationService validationService;
    private final ModifyResponseService modifyResponseService;
    private final ModifyRequestService modifyRequestService;
    private final ModifyRequestService modifySourceRequestService;

    @Autowired
    public MyController(ValidationService validationService,
                        @Qualifier("ModifySystemTimeResponseService") ModifyResponseService modifyResponseService,
                        ModifyRequestService modifyRequestService,
                        @Qualifier("modifySourceRequestService") ModifyRequestService modifySourceRequestService) {
        this.validationService = validationService;
        this.modifyResponseService = modifyResponseService;
        this.modifyRequestService = modifyRequestService;
        this.modifySourceRequestService = modifySourceRequestService;
    }

    @PostMapping("/feedback")
    public ResponseEntity<Response> feedback(@Valid @RequestBody Request request, BindingResult bindingResult) {

        log.info("request: {}", request);

        Response response = Response.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemTime(DateTimeUtil.getCustomFormat().format(new Date()))
                .code(Codes.SUCCESS.toString())
                .errorCode(ErrorCodes.EMPTY.toString())
                .errorMessage(ErrorMessages.EMPTY.toString())
                .build();

        log.info("response: {}", response);

        try {
            validationService.isValid(bindingResult);
        } catch (ValidationFailedException e) {
            response.setCode(Codes.FAILED.toString());
            response.setErrorCode(ErrorCodes.VALIDATION_EXCEPTION.toString());
            response.setErrorMessage(ErrorMessages.VALIDATION.toString());
            log.error("validation exception: {}", response);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        catch (Exception e) {
            response.setCode(Codes.FAILED.toString());
            response.setErrorCode(ErrorCodes.UNKNOWN_EXCEPTION.toString());
            response.setErrorMessage(ErrorMessages.UNKNOWN.toString());
            log.error("unknown exception: {}", response);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        try {
            validationService.isCodeValid(request);
        } catch (UnsupportedCodeException e) {
            response.setCode(Codes.FAILED.toString());
            response.setErrorCode(ErrorCodes.VALIDATION_CODE_EXCEPTION.toString());
            response.setErrorMessage(ErrorMessages.UNSUPPORTED_UID.toString());
            log.error("unsupported uid: {}", response);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        modifyResponseService.modify(response);
        modifyRequestService.modify(request);
        modifySourceRequestService.modify(request);

        return new ResponseEntity<>(modifyResponseService.modify(response), HttpStatus.OK);
    }
}
