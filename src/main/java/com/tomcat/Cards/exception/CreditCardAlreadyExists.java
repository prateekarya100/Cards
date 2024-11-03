package com.tomcat.Cards.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.ALREADY_REPORTED)
public class CreditCardAlreadyExists extends RuntimeException {
    public CreditCardAlreadyExists(String mobileNumber) {
        super("credit card already exists with mobile number : " + mobileNumber);
    }
}
