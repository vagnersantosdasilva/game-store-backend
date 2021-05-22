package br.com.supera.game.store.service;

import br.com.supera.game.store.model.Product;
import br.com.supera.game.store.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameStoreService {

    @Autowired
    ProductRepository productRepository;

    //pegar o caminho dos arquivos e repassar
    public List<Product> getGames(){
        return null;
    }
}
