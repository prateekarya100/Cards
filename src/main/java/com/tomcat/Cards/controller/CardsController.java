package com.tomcat.Cards.controller;

import com.tomcat.Cards.dto.CardsDto;
import com.tomcat.Cards.dto.ResponseDto;
import com.tomcat.Cards.model.Cards;
import com.tomcat.Cards.service.iCardsServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.smartcardio.CardNotPresentException;
import java.util.List;

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
                            "woohooo!!, your credit card has been issued"));
        }else{
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseDto(
                    HttpStatus.EXPECTATION_FAILED,"card not processed due to technical error"
            ));
        }
    }

    @GetMapping(value = "/fetchCard")
    public ResponseEntity<CardsDto> fetchCard(@RequestParam String cardNumber){
        CardsDto cardsDto = cardsServices.fetchCardDetailsByCardNumber(cardNumber);
        if(cardsDto != null){
            return ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .body(cardsDto);
        }else{
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(null);
        }
    }

    /**
     * @Param- mobileNumber used to fetch card on which we want to update details
     *         like upgrade credit limit,extend expiration date, change card type,
     *         made card status active or freeze
     */
    @PutMapping(value = "/updateCard")
    public ResponseEntity<ResponseDto> updateCard(@RequestBody CardsDto cardsDto){
        boolean isCardUpdated=cardsServices.cardDetailsUpdation(cardsDto);
        if(isCardUpdated){
            return ResponseEntity.status(HttpStatus.ACCEPTED)
                    .body(new ResponseDto(HttpStatus.ACCEPTED,"your card details updated successfully"));
        }else{
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseDto(
                    HttpStatus.EXPECTATION_FAILED,"your card is not processed due to technical error,please try again and contact to your bank or website development team"
            ));
        }
    }

    @DeleteMapping(value = "/cardClosure")
    public ResponseEntity<ResponseDto> cardClosureRequestProcess(@RequestParam String mobileNumber){
        boolean isClosed=cardsServices.cardClosureHandler(mobileNumber);
        if (isClosed){
            return new ResponseEntity<>(new ResponseDto(
                    HttpStatus.OK,"your card is closed successfully, we're unhappy to see this our valued customer will not take our services anymore"
            ), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(
                    new ResponseDto(HttpStatus.EXPECTATION_FAILED,
                            "card closure request not processed due to technical error, please contact to your bank or website development team"),
                    HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping(value = "/allCards")
    public List<Cards> fetchAllCards() {
        return cardsServices.fetchingAllCustomersCards();
    }
}
