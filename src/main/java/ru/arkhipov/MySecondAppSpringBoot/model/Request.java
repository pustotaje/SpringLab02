package ru.arkhipov.MySecondAppSpringBoot.model;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Request {
    @NotBlank
    @NotNull
    private String uid;
    @NotBlank
    private String operationUid;
    private Systems systemName;
    private String systemTime;
    private String source;
    private int communicationId;
    private int templateId;
    private String productCode;
    private int smsCode;

    //@AssertTrue(message = "uid не может быть равен 123")
    public boolean isUidValid() {
        return !uid.equals("123");
    }

    public String toString() {
        return "{" +
                "uid='" + uid + '\'' +
                ", operationUid='" + operationUid + '\'' +
                ", systemName='" + systemName + '\'' +
                ", systemTime='" + systemTime + '\'' +
                ", source='" + source + '\'' +
                ", communicationId" + communicationId +'\'' +
                ", templateId=" + templateId +
                ", productCode=" + productCode +
                ", smsCode=" + smsCode +
                "}";
    }
}
