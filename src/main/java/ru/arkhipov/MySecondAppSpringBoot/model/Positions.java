package ru.arkhipov.MySecondAppSpringBoot.model;

import lombok.Getter;

@Getter
public enum Positions {
    DEV(2.2, false),
    HR(1.2, false),
    TL(2.6, false),
    MANAGER(3.0, true), // Пример новой позиции
    LEAD(4.0, true),     // Пример новой позиции
    CEO(5.0, true);      // Пример новой позиции

    private final double positionCoefficient;
    private final boolean isManager;

    Positions(double positionCoefficient, boolean isManager) {
        this.positionCoefficient = positionCoefficient;
        this.isManager = isManager;
    }

    public boolean isManager() {
        return isManager;
    }

    public double getPositionCoefficient() {
        return positionCoefficient;
    }
}