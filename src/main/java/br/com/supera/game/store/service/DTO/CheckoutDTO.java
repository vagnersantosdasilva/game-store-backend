package br.com.supera.game.store.service.DTO;


import br.com.supera.game.store.model.CreditCard;
import br.com.supera.game.store.model.ShoppingCart;


public class CheckoutDTO {


    private String name;
    private String cpf;
    private String endereco;
    private CreditCard creditCard;



    public CheckoutDTO(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

}
