package com.ibm.creditcard.controllers;

import com.ibm.creditcard.model.entities.CreditCard;
import com.ibm.creditcard.services.CreditCardDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/creditCard")
public class CreditCardController
{
    @Autowired
    private CreditCardDAO creditCardDao;

    @PostMapping("/altaProductoTarjetaCredito")
    public ResponseEntity<?>save(@RequestBody CreditCard creditCard, BindingResult result)
    {
        CreditCard creditCard1 = creditCardDao.save(creditCard);

        return new ResponseEntity<CreditCard>(creditCard1, HttpStatus.CREATED);

    }

    @GetMapping("/sugerencia")
    public ResponseEntity<?> buscarTarjetaSugerida(@RequestBody String yourPassion, Double monthlySalaryFrom, Double monthlySalaryTo,Integer ageFrom, Integer ageTo)
    {
        Optional<CreditCard> creditCard = creditCardDao.buscarTarjetaSugerida(yourPassion, monthlySalaryFrom, monthlySalaryTo,ageFrom, ageTo);
        return new ResponseEntity<Optional<CreditCard>>(creditCard, HttpStatus.OK);
    }

}
