package com.tomcat.Cards.controller;

import com.tomcat.Cards.dto.ResponseDto;
import com.tomcat.Cards.service.iCardsServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.smartcardio.CardNotPresentException;

@RestController
@RequestMapping(path = "/api/cards",produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class CardsController {

    private iCardsServices cardsServices;

    @PostMapping(value = "/issueCard")
    public ResponseEntity<ResponseDto> issueNewCard(@RequestParam
                                                        String mobileNumber) throws CardNotPresentException {
        boolean isCardIssued = cardsServices.createNewCard(mobileNumber);
        if(isCardIssued){
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ResponseDto(HttpStatus.ACCEPTED,
                            "woohooo!!, your card has been issued"));
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDto(
                    HttpStatus.EXPECTATION_FAILED,"card not processed due to technical error"
            ));
        }
    }
}
