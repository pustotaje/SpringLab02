package ru.arkhipov.MySecondAppSpringBoot.service;

import ru.arkhipov.MySecondAppSpringBoot.model.Positions;
import org.springframework.stereotype.Service;

@Service
public interface AnnualBonusService {

    double calculate(Positions positions, double salary, double bonus, int workDays);
}