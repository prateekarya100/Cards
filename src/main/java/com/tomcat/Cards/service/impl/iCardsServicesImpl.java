package com.tomcat.Cards.service.impl;

import com.tomcat.Cards.exception.CreditCardAlreadyExists;
import com.tomcat.Cards.model.Cards;
import com.tomcat.Cards.repository.CardsRepository;
import com.tomcat.Cards.service.iCardsServices;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class iCardsServicesImpl implements iCardsServices {

    private CardsRepository cardsRepository;

    /**
     * @param mobileNumber
     * @return
     */
    @Override
    public boolean createNewCard(String mobileNumber) {
        Cards cards = cardsRepository.findByMobileNumber(mobileNumber).orElseThrow(
                ()->new CreditCardAlreadyExists(mobileNumber)
        );
        System.out.println(cards);
        return true;
    }

//    private Cards createNewCreditCardToCustomer(String mobileNumber) {
//        Cards cards = new Cards();
//        long cardNumber = 10000000000L+new Random(900000000).nextLong();
//        long cardCVVNumber = 100L+new Random(900000000).nextLong();
//        System.out.println("cardNumber :: "+cardNumber);
//        System.out.println("cardNumber :: "+cardNumber);
//        cards.setCardNumber(String.valueOf(cardNumber));
//        cards.setCardCVV(cardCVVNumber);
//        return cards;
//    }
}
