package br.com.supera.game.store.repository;

import br.com.supera.game.store.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    @Query(nativeQuery = true,value = "select * from product where id=?1")
    Product findProductById(long id);
}
