package com.tomcat.Cards.repository;

import com.tomcat.Cards.model.Cards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardsRepository extends JpaRepository<Cards, Long> {
    Cards findByMobileNumber(String mobileNumber);

    Optional<Cards> findByCardNumber(String cardNumber);

    Optional<Cards> deleteByCustomerMobileNumber(String mobileNumber);
}
