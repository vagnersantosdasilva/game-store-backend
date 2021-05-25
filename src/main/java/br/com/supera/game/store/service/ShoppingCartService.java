package br.com.supera.game.store.service;

import br.com.supera.game.store.model.Product;
import br.com.supera.game.store.model.ShoppingCart;
import br.com.supera.game.store.model.User;
import br.com.supera.game.store.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class ShoppingCartService {

    private Map<Integer, ShoppingCart> userCart= new LinkedHashMap<>();

    @Autowired
    ProductRepository productRepository;

    public ShoppingCart createCart(Integer user){
        if (userCart.get(user)==null){
            ShoppingCart shoppingCart = new ShoppingCart();
            shoppingCart.setUserId(user);
            userCart.put(user, shoppingCart);
            return shoppingCart;
        }
        return userCart.get(user);
    }

    public ShoppingCart addProduct(Long id, Integer user) throws Exception {

        Product product = productRepository.findProductById(id);
        if (product==null) throw new Exception("O produto solicitado não está registrado");
        if (getShoppingCart(user)!=null){
            ShoppingCart shoppingCart = getShoppingCart(user);
            shoppingCart.addProduct(product);
            return shoppingCart;
        }
        ShoppingCart shoppingCart = createCart(user);
        shoppingCart.addProduct(product);

        return shoppingCart;
    }

    public ShoppingCart removeProduct(Long id,Integer user) throws Exception{
        ShoppingCart shoppingCart = getShoppingCart(user,"name",true);
        shoppingCart.remove(id);
        if (shoppingCart.getProducts().size()==0) {
            shoppingCart = new ShoppingCart();
            shoppingCart.setUserId(user);
        }
        return shoppingCart;
    }

    public ShoppingCart getShoppingCart(Integer user,String orderby,Boolean ascending) throws Exception {
        if ((userCart.get(user))!=null){
            ShoppingCart shoppingCart  = userCart.get(user);
            shoppingCart.sortProducts(orderby,ascending);
            return shoppingCart;
        }
        throw new Exception("Recurso não encontrado");
    }

    public ShoppingCart getShoppingCart(Integer user){
        return userCart.get(user);
    }
}