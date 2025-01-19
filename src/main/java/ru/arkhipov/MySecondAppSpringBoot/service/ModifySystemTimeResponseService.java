package ru.arkhipov.MySecondAppSpringBoot.service;

import ru.arkhipov.MySecondAppSpringBoot.model.Response;

import java.time.Instant;

public class ModifySystemTimeResponseService {

    // Ваши другие методы

    public void modifyResponse(Response response) {
        // Если у вас есть строка, которую нужно преобразовать в Instant
        String systemTimeString = "2025-01-19T20:08:06.445Z"; // Пример строки

        // Преобразуем строку в Instant
        Instant systemTime = Instant.parse(systemTimeString);

        // Устанавливаем в объект response
        response.setSystemTime(systemTime);
    }
}
