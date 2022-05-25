package com.ibm.creditcard.controllers;

import com.ibm.creditcard.model.entities.CreditCard;
import com.ibm.creditcard.services.CreditCardDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Optional;

@RestController
@RequestMapping("/creditCard")
public class CreditCardController
{
    @Autowired
    private CircuitBreakerFactory circuitBreaker;

    @Autowired
    private CreditCardDAO creditCardDao;

    @PostMapping("/altaProductoTarjetaCredito")
    public ResponseEntity<?>save(@RequestBody CreditCard creditCard, BindingResult result)
    {
        CreditCard creditCard1 = creditCardDao.save(creditCard);

        return new ResponseEntity<CreditCard>(creditCard1, HttpStatus.CREATED);

    }

    @GetMapping("/sugerencia")
    public ResponseEntity<?> buscarTarjetaSugerida(@RequestParam(name="passion") String yourPassion, @RequestParam(name="salary") Double monthlySalary, @RequestParam Integer age)
    {
        return circuitBreaker.create("tarjetas")
                .run(()->{
                    Iterable<CreditCard> creditCard = creditCardDao.buscarTarjetaSugerida(yourPassion, monthlySalary,age);
                    if(true){
                        throw new RuntimeException("Fallo a la peticion");
                    }
                    return new ResponseEntity<Iterable<CreditCard>>(creditCard, HttpStatus.OK);
                }, e-> metodoAlternativo(yourPassion,monthlySalary,age,e));

    }

    public ResponseEntity<?> metodoAlternativo(String yourPassion, Double monthlySalary, Integer age, Throwable e)
    {
        HashMap<String, String> sugerencia = new HashMap<String, String>();

        sugerencia.put("passion",yourPassion);
        sugerencia.put("monthlySalary",monthlySalary.toString());
        sugerencia.put("age",age.toString());

        return new ResponseEntity<>(sugerencia,HttpStatus.REQUEST_TIMEOUT);
    }
}














