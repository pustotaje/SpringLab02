package ru.arkhipov.MySecondAppSpringBoot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.arkhipov.MySecondAppSpringBoot.model.Request;
import ru.arkhipov.MySecondAppSpringBoot.model.Response;
import ru.arkhipov.MySecondAppSpringBoot.service.ModifySourceRequestService;

import java.time.Instant;

@RestController
@RequestMapping("/feedback")
public class MyController {

    private final ModifySourceRequestService modifySourceRequestService;

    public MyController(ModifySourceRequestService modifySourceRequestService) {
        this.modifySourceRequestService = modifySourceRequestService;
    }

    @PostMapping
    public ResponseEntity<Response> feedback(@RequestBody Request request) {
        // Логика для обработки запроса
        Response response = new Response();
        response.setUid(request.getUid());
        response.setOperationUid(request.getOperationUid());
        response.setSystemTime(Instant.now());

        // Пример: рассчитать бонус на основе данных запроса
        response.setAnnualBonus(calculateAnnualBonus(request)); // Пример вычисления
        response.setErrorCode("none");
        response.setErrorMessage("No errors");

        // Дополнительные данные
        response.setPosition(request.getPosition());
        response.setSalary(request.getSalary());
        response.setWorkDays(request.getWorkDays());

        return ResponseEntity.ok(response);
    }

    private Double calculateAnnualBonus(Request request) {
        // Логика для расчета бонуса
        // Например, бонус рассчитывается как 10% от зарплаты
        return request.getSalary() * 0.1;
    }
}