package br.com.supera.game.store.controller;

import br.com.supera.game.store.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/gamestore")
public class GameStoreController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/games")
    public ResponseEntity<?> getGames ()throws Exception{
        ResponseEntity response =  new ResponseEntity (productRepository.findAll(), HttpStatus.OK);
        return response;
    }

    @GetMapping("/games/{id}")
    public ResponseEntity<?> getGame (@PathVariable Long id) throws Exception{
        ResponseEntity response =  new ResponseEntity (productRepository.findProductById(id),HttpStatus.OK);
        return response;
    }


}
