package com.ibm.creditcard.services;

import com.ibm.creditcard.model.entities.CreditCard;

import java.util.Optional;

public interface CreditCardDAO
{

    public Optional<CreditCard> buscarTarjetaSugerida(String yourPassion, Double monthlySalary, Integer age );
}
