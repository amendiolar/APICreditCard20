package com.ibm.creditcard.services;

import com.ibm.creditcard.model.entities.CreditCard;
import com.ibm.creditcard.repositories.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CreditCardDAOImpl implements CreditCardDAO
{
    @Autowired
    private CreditCardRepository creditCardRepository;

    @Override
    public CreditCard save(CreditCard entidad)
    {
        return creditCardRepository.save(entidad);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<CreditCard> buscarTarjetaSugerida(String yourPassion, Double monthlySalary,Integer age )
    {
        return creditCardRepository.buscarTarjetaSugerida(yourPassion, monthlySalary,age );
    }
}
