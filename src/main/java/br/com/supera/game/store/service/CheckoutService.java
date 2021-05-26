package br.com.supera.game.store.service;

import br.com.caelum.stella.validation.CPFValidator;
import br.com.supera.game.store.adapter.FictionalCardOperatorAdapter;
import br.com.supera.game.store.model.Checkout;
import br.com.supera.game.store.model.CreditCard;
import br.com.supera.game.store.repository.CheckoutRepository;
import br.com.supera.game.store.service.DTO.CheckoutDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class CheckoutService {


    private ShoppingCartService shoppingCartService;
    private FictionalCardOperatorAdapter adapterApi;
    private CheckoutRepository checkoutRepository;

    public CheckoutService (ShoppingCartService shoppingCartService,
                            FictionalCardOperatorAdapter adapterApi,
                            CheckoutRepository checkoutRepository
    ){
        this.shoppingCartService=shoppingCartService;
        this.adapterApi=adapterApi;
        this.checkoutRepository = checkoutRepository;
    }

    public Boolean pay (CheckoutDTO checkout ,Integer userId){
        if (isValidCheckout(checkout)) {
            Checkout check = new Checkout();
            check.setCreateAt(new Date());
            check.setCreditCard(checkout.getCreditCard().getCardNumber());
            check.setEndereco(checkout.getEndereco());
            check.setCpf(checkout.getCpf());
            check.setName(checkout.getName());
            if (shoppingCartService.getShoppingCart(userId) ==null) throw new RuntimeException("Carrinho não pode ser vazio!");
            check.setTotal((shoppingCartService.getShoppingCart(userId).getTotal()));
            if (adapterApi.performPayment(checkout.getCreditCard(), check.getTotal())) {
                checkoutRepository.save(check);
                return true;
            }
            else throw new RuntimeException("Erro na api de pagamento!");

        }
        return null;
    }

    public Boolean isValidCheckout(CheckoutDTO checkout) {
        if (isCreditCardValid(checkout) &&
                isEnderecoValid(checkout) &&
                isValidCPF(checkout) &&
                isValidName(checkout)) return true;

        else throw new RuntimeException("Erro de validação");
    }

    private Boolean isValidCPF(CheckoutDTO checkout){
        CPFValidator validator = new CPFValidator();
        return validator.isEligible(checkout.getCpf());
    }

    private Boolean isValidName (CheckoutDTO checkout){
        if (checkout.getName().length()<3) return false;
        return true;
    }

    private Boolean isCreditCardValid(CheckoutDTO checkout){
        if (checkout.getCreditCard().getCardNumber().length()!=16) return false;
        return true;
    }

    private Boolean isEnderecoValid(CheckoutDTO checkout){
        if (checkout.getEndereco()!=null) return true;
        return false;
    }

    
}
