package com.tomcat.Cards.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data @AllArgsConstructor @NoArgsConstructor
public class CardsDto {
    private String mobileNumber;
    private String cardNumber;
    private String cardType;
    private LocalDateTime cardExpiryDate;
    private long cardCVV;
    private String cardName;
    private String cardStatus;
    private String cardIssuerBank;
    private long totalLimit;
    private long availableLimit;
    private long amountUsed;
}
