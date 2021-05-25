package br.com.supera.game.store.adapter;

import br.com.supera.game.store.model.CreditCard;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class FictionalCardOperatorAdapter {

    //Chamadas para apis de operadoras de cartão externas
    public boolean performPayment(CreditCard creditCard, BigDecimal total){
        return true;
    }
}
