package br.com.supera.game.store.service;

import br.com.supera.game.store.model.Product;
import br.com.supera.game.store.repository.ProductRepository;
import br.com.supera.game.store.utils.ComparatorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameStoreService {

    private ProductRepository productRepository;

    @Autowired
    public GameStoreService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<Product> getGames(String field){
        if (field ==null || field.length()==0)  field ="name";
        ComparatorUtils camparator = new ComparatorUtils(field,true);
        List<Product> products = productRepository.findAll();

        products.stream()
                .forEach(e->e.setImage(getFullPath(e.getImage())));
        products.sort(camparator);
        return products;
    }

    private String getFullPath(String file){
        System.out.println(getClass().getClassLoader().getResource(file));
        return file;
    }

    public Product getGameById(Long id){
        return productRepository.findProductById(id);
    }

    public String pay(){
        return null;
    }

}
