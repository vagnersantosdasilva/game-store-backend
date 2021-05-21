package br.com.supera.game.store.test;

import br.com.supera.game.store.model.Product;
import br.com.supera.game.store.repository.ProductRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;

@Component
public class InsertProductTest {

    @Autowired
    private ProductRepository productRepository;


    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Product p1 = new Product("Super Mario Odyssey",
                BigDecimal.valueOf(197.88),
                (short) 100,
                "super-mario-odyssey.png");

        Product p2 = new Product("Call Of Duty Infinite Warfare",
                BigDecimal.valueOf(49.99),
                (short) 80,
                "call-of-duty-infinite-warfare.png");

        Product p3 = new Product("The Witcher III Wild Hunt",
                BigDecimal.valueOf(119.5),
                (short) 250,
                "the-witcher-iii-wild-hunt.png");

        Product p4 = new Product("Call Of Duty WWII",
                BigDecimal.valueOf(249.99),
                (short) 205,
                "call-of-duty-wwii.png");

        Product p5 = new Product("Mortal Kombat XL",
                BigDecimal.valueOf(119.5),
                (short) 69.9,
                "mortal-kombat-xl.png");

        productRepository.save(Arrays.asList(p1, p2, p3, p4, p5));



    }
}

/*
*
*  name: "Super Mario Odyssey"
    price: 197.88
    score: 100
    image: "super-mario-odyssey.png"
  - id: 201
    name: "Call Of Duty Infinite Warfare"
    price: 49.99
    score: 80
    image: "call-of-duty-infinite-warfare.png"
  - id: 102
    name: "The Witcher III Wild Hunt"
    price: 119.5
    score: 250
    image: "the-witcher-iii-wild-hunt.png"
  - id:  99
    name: "Call Of Duty WWII"
    price: 249.99
    score: 205
    image: "call-of-duty-wwii.png"
  - id: 12
    name: "Mortal Kombat XL"
    price: 69.99
    score: 150
    image: "mortal-kombat-xl.png"
  - id: 74
    name: "Shards of Darkness"
    price: 71.94
    score: 400
    image: "shards-of-darkness.png"
  - id: 31
    name: "Terra Média: Sombras de Mordor"
    price: 79.99
    score: 50
    image: "terra-media-sombras-de-mordor.png"
  - id: 420
    name: "FIFA 18"
    price: 195.39
    score: 325
    image: "fifa-18.png"
  - id: 501
    name: "Horizon Zero Dawn"
    price: 115.8
    score: 290
    image: "horizon-zero-dawn.png"
* */