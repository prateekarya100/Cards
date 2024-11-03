package com.tomcat.Cards.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter @Getter @AllArgsConstructor @NoArgsConstructor
@Entity
public class Cards extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cardsId;

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
