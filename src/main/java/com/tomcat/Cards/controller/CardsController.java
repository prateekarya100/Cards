package com.tomcat.Cards.controller;

import com.tomcat.Cards.dto.ResponseDto;
import com.tomcat.Cards.service.iCardsServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/cards",produces = MediaType.APPLICATION_JSON_VALUE)
public class CardsController {

    private iCardsServices cardsServices;

    @PostMapping(value = "/issueCard")
    public ResponseEntity<ResponseDto> issueNewCard(@RequestParam
                                                        String mobileNumber){
       boolean isCardCreated = cardsServices.createNewCard(mobileNumber);
       if(isCardCreated){
           return ResponseEntity.status(HttpStatus.OK)
                   .body(new ResponseDto(HttpStatus.OK,
                           "woohooo!!!,your new credit card issued successfully"));
       }else{
           return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                   .body(new ResponseDto(HttpStatus.OK,
                           "oops, something went wrong, please try again or contact the bank or website development team"));
       }
    }
}
