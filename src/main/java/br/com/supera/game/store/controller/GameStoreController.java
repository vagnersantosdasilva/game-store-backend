package br.com.supera.game.store.controller;

import br.com.supera.game.store.model.CreditCard;
import br.com.supera.game.store.model.Product;
import br.com.supera.game.store.model.ShoppingCart;
import br.com.supera.game.store.model.User;
import br.com.supera.game.store.service.GameStoreService;
import br.com.supera.game.store.service.ShoppingCartService;

import br.com.supera.game.store.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Controller
@RequestMapping("/gamestore")
public class GameStoreController {

    private GameStoreService gameStoreService;
    private ShoppingCartService shoppingCartService;

    @Autowired
    public GameStoreController(GameStoreService gameStoreService , ShoppingCartService shoppingCartService){
        this.gameStoreService = gameStoreService;
        this.shoppingCartService = shoppingCartService ;
    }

    @GetMapping("/games")
    public ResponseEntity<?> getGames (
            @RequestHeader ("sorted_by")String field
    )throws Exception{
        ResponseEntity response =  new ResponseEntity (gameStoreService.getGames(field), HttpStatus.OK);
        return response;
    }

    @GetMapping("/games/{id}")
    public ResponseEntity<?> getGame (@PathVariable Long id) throws Exception{

        ResponseEntity response =  new ResponseEntity (gameStoreService.getGameById(id),HttpStatus.OK);
        return response;
    }

    @PostMapping("/games/pay")
    public ResponseEntity<?> payGames (
            @RequestBody User user,
            @RequestBody List<Product> products,
            @RequestBody CreditCard credCard,
            @RequestBody Integer installments
    ) throws Exception{

        //gameStoreService.pay(user,games)
        ResponseEntity response =  new ResponseEntity (null,HttpStatus.OK);
        return response;
    }

    @GetMapping("/cart")
    public ResponseEntity<?> getShoppingCart(@RequestBody User user,
                                             @RequestHeader("sorted_by")String orderby,
                                             @RequestHeader("ascending")Boolean ascending) throws Exception {

        ShoppingCart shoppingCart = shoppingCartService.getShoppingCart(user,orderby,ascending);
        ResponseEntity response = new ResponseEntity( shoppingCart,HttpStatus.OK);
        return response;
    }

    @PostMapping("/cart")
    public ResponseEntity<?> createShoppingCart(@RequestBody User user) {
        ShoppingCart shoppingCart = shoppingCartService.createCart(user);
        ResponseEntity response = new ResponseEntity(
                shoppingCart, HttpStatus.CREATED
        );
        return response;
    }

    @PostMapping("/cart/product/{productId}")
    public ResponseEntity<?> addProduct(@PathVariable Long productId,@RequestBody User user) throws Exception {
        ShoppingCart sc = shoppingCartService.addProduct(productId,user);
        ResponseEntity <?> response = new ResponseEntity(sc,HttpStatus.OK);
        return response;

    }

    @DeleteMapping("/cart/product/{id}")
    public ResponseEntity<?> removeProduct(@PathVariable("id") Long id,
                                           @RequestBody User user)throws Exception{

        ShoppingCart shoppingCart = shoppingCartService.removeProduct(id,user);
        ResponseEntity<?> response = new ResponseEntity(shoppingCart,HttpStatus.OK);
        return response;
    }

    @GetMapping("/product/image/{name}")
    public ResponseEntity<?> getImage(@PathVariable("name") String name) throws Exception {
        System.out.println(name);
        FileUtils file = new FileUtils();
        String f = "/".concat(name).concat(".png");
        byte [] fileImage = file.getImage(f);

        ResponseEntity<?> response = new ResponseEntity(fileImage,HttpStatus.OK);
        return response;
    }

}

/*
* http://localhost:8081/gamestore/cart/product/image/call-of-duty-infinite-warfare.png
* */