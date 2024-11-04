package com.tomcat.Cards.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data @AllArgsConstructor @NoArgsConstructor
@Schema(
        name = "Cards",
        description = "schema to hold card related information"
)
public class CardsDto {
    @Schema(
            description = "mobile number of the customer",example = "9123456789"
    )
    private String mobileNumber;

    @Schema(
            description = "customers bank card number",example = "1122334455"
    )
    private String cardNumber;

    @Schema(
            description = "card type of the customer",example = "credit_card"
    )
    private String cardType;

    @Schema(
            description = "2024-11-04T14:15:19.405+05:30",example = "9123456789"
    )
    private LocalDateTime cardExpiryDate;

    @Schema(
            description = "card 3 digit cvv number",example = "123"
    )
    private long cardCVV;

    @Schema(
            description = "name of the card",example = "coral"
    )
    private String cardName;

    @Schema(
            description = "status of card whether active or freeze",example = "active"
    )
    private String cardStatus;

    @Schema(
            description = "name of the card issuer bank",example = "sbi credit cards"
    )
    private String cardIssuerBank;

    @Schema(
            description = "total limit of the card",example = "500000"
    )
    private long totalLimit;

    @Schema(
            description = "available limit of the card",example = "500000"
    )
    private long availableLimit;
    @Schema(
            description = "card amount utilized by customer",example = "10000"
    )
    private long amountUsed;
}
