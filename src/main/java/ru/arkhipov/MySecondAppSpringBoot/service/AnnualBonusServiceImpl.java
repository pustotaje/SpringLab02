package ru.arkhipov.MySecondAppSpringBoot.service;

import ru.arkhipov.MySecondAppSpringBoot.model.Positions;
import org.springframework.stereotype.Service;

@Service
public class AnnualBonusServiceImpl implements AnnualBonusService {

    public double calculate(Positions position, double salary, double bonus, int workDays) {
        int yearDays = 365;
        if (isLeapYear()) {
            yearDays = 366;
        }
        return salary * bonus * yearDays * position.getPositionCoefficient() / workDays;
    }

    private boolean isLeapYear() {
        int year = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // Метод для квартальной премии
    public double calculateQuarterlyBonus(Positions position, double salary, double bonus, int workDays) {
        if (!position.isManager()) {
            throw new IllegalArgumentException("This method is only for managers.");
        }
        return calculate(position, salary, bonus, workDays) / 4;
    }
}