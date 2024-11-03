package com.tomcat.Cards.service.impl;

import com.tomcat.Cards.constants.CardsConstants;
import com.tomcat.Cards.exception.CreditCardAlreadyExists;
import com.tomcat.Cards.model.Cards;
import com.tomcat.Cards.repository.CardsRepository;
import com.tomcat.Cards.service.iCardsServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
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
            Cards card = cardsRepository.findByMobileNumber(mobileNumber);
            if (card != null) {
                throw new CreditCardAlreadyExists("card","mobile",mobileNumber);
            }else {
                cardsRepository.save(newCardIssued(mobileNumber));
                return true;
            }
    }

    private Cards newCardIssued(String mobileNumber) {
        Cards card = new Cards();

        long newCreditCardNumber = 1000000000L + new Random().nextLong(900000000);
        long card_CVV_code = 100L+new Random().nextLong(900);

        card.setMobileNumber(mobileNumber);
        card.setTotalLimit(CardsConstants.CARD_LIMIT);
        card.setCardCVV(card_CVV_code);
        card.setCardNumber(String.valueOf(card_CVV_code));
        card.setCardName(CardsConstants.CARD_NAME2);
        card.setCardIssuerBank(CardsConstants.CARD_ISSUER_BANK1);
        card.setCardExpiryDate(LocalDateTime.now().plusYears(4));
        card.setAvailableLimit(CardsConstants.CARD_LIMIT);
        card.setCardType(CardsConstants.CREDIT_CARD);
        card.setCardStatus(CardsConstants.CARD_STATUS_ACTIVE);
        return card;
    }
}
