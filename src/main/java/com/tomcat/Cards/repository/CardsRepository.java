package com.tomcat.Cards.repository;

import com.tomcat.Cards.model.Cards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardsRepository extends JpaRepository<Cards, Long> {
    Cards findByMobileNumber(String mobileNumber);
}
