package com.tomcat.Cards.service;

import javax.smartcardio.CardNotPresentException;

public interface iCardsServices {
    boolean createNewCard(String mobileNumber) throws CardNotPresentException;
}
