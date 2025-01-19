package ru.arkhipov.MySecondAppSpringBoot.service;

import ru.arkhipov.MySecondAppSpringBoot.model.Response;
import org.springframework.stereotype.Service;

@Service
public interface ModifyResponseService {
    Response modify(Response response);
}