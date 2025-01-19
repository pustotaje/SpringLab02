package ru.arkhipov.MySecondAppSpringBoot.model;

import java.time.Instant;

public class Response {
    private String uid;
    private String operationUid;
    private Instant systemTime;
    private String code;
    private Double annualBonus;
    private String errorCode;
    private String errorMessage;
    private String position;
    private double salary;
    private int workDays;

    // Getters and setters
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getOperationUid() {
        return operationUid;
    }

    public void setOperationUid(String operationUid) {
        this.operationUid = operationUid;
    }

    public Instant getSystemTime() {
        return systemTime;
    }

    public void setSystemTime(Instant systemTime) {
        this.systemTime = systemTime;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getAnnualBonus() {
        return annualBonus;
    }

    public void setAnnualBonus(Double annualBonus) {
        this.annualBonus = annualBonus;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getWorkDays() {
        return workDays;
    }

    public void setWorkDays(int workDays) {
        this.workDays = workDays;
    }
}