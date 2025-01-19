package ru.arkhipov.MySecondAppSpringBoot.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import ru.arkhipov.MySecondAppSpringBoot.model.Request;

@Service
public class ModifySourceRequestService implements ModifyRequestService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void modify(Request request) {
        request.setSource("Modified source");
        HttpEntity<Request> httpEntity = new HttpEntity<>(request);
        try {
            restTemplate.exchange("http://localhost:8084/feedback", HttpMethod.POST,
                    httpEntity, new ParameterizedTypeReference<>() {});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
