package br.com.supera.game.store.repository;

import br.com.supera.game.store.model.Checkout;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckoutRepository extends JpaRepository<Checkout,Integer> {
}
