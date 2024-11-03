package com.tomcat.Cards.mapper;

import com.tomcat.Cards.dto.CardsDto;
import com.tomcat.Cards.model.Cards;

public class CardsMapper {

    private Cards mapToCards(CardsDto cardsDto, Cards cards) {
        cards.setCardStatus(cardsDto.getCardStatus());
        cards.setCardType(cardsDto.getCardType());
        cards.setCardNumber(cardsDto.getCardNumber());
        cards.setCardCVV(cardsDto.getCardCVV());
        cards.setCardName(cardsDto.getCardName());
        cards.setCardExpiryDate(cardsDto.getCardExpiryDate());
        cards.setCardIssuerBank(cardsDto.getCardIssuerBank());
        cards.setAvailableLimit(cardsDto.getAvailableLimit());
        cards.setAmountUsed(cardsDto.getAmountUsed());
        return cards;
    }

    private CardsDto mapToDto(Cards cards, CardsDto cardsDto) {
        cardsDto.setCardStatus(cards.getCardStatus());
        cardsDto.setCardType(cards.getCardType());
        cardsDto.setCardNumber(cards.getCardNumber());
        cardsDto.setCardCVV(cards.getCardCVV());
        cardsDto.setCardName(cards.getCardName());
        cardsDto.setCardExpiryDate(cards.getCardExpiryDate());
        cardsDto.setCardIssuerBank(cards.getCardIssuerBank());
        cardsDto.setAvailableLimit(cards.getAvailableLimit());
        cardsDto.setAmountUsed(cards.getAmountUsed());
        return cardsDto;
    }
}
