package ru.arkhipov.MySecondAppSpringBoot.model;

public enum ErrorMessages {
    EMPTY(""),
    VALIDATION("Ошибка валидации"),
    UNKNOWN("Неподдерживаемая ошибка"),
    UNSUPPORTED_UID("id не должен быть равен 123");
    private final String discription;
    ErrorMessages(String discription) {
        this.discription = discription;}
    public String getName() {
        return discription;}
}