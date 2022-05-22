package com.ibm.creditcard.repositories;

import com.ibm.creditcard.model.entities.CreditCard;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CreditCardRepository extends CrudRepository<CreditCard, Long>
{

    @Query("select c from CreditCard c where c.yourPassion = ?1 and c.monthlySalaryFrom <= ?2 and c.monthlySalaryTo >= ?3 and c.ageFrom <= ?4 and c.ageTo >= ?5")
    public Optional<CreditCard> buscarTarjetaSugerida(String yourPassion, Double monthlySalaryFrom, Double monthlySalaryTo,Integer ageFrom, Integer ageTo );
}
