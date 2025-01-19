package ru.arkhipov.MySecondAppSpringBoot.service;

import ru.arkhipov.MySecondAppSpringBoot.model.Request;
import ru.arkhipov.MySecondAppSpringBoot.model.Systems;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

public class ModifySystemNameRequestService implements ModifyRequestService {
    @Override
    public void modify(Request request) {
        // Преобразуем объект Systems в строку
        String systemName = Systems.S1.toString(); // Используем toString() для получения строкового значения

        // Устанавливаем строковое значение в поле systemName
        request.setSystemName(systemName);

        HttpEntity<Request> httpEntity = new HttpEntity<>(request);
        new RestTemplate().exchange("http://localhost:8084/feedback", HttpMethod.POST,
                httpEntity, new ParameterizedTypeReference<>() {
                });
    }
}