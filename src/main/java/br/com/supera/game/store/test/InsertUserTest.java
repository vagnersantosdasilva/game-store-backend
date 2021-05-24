package br.com.supera.game.store.test;

import br.com.supera.game.store.model.User;
import br.com.supera.game.store.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


@Component
public class InsertUserTest {

    @Autowired
    UserRepository userRepository;

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {

        User user = new User();
        user.setName("Teste");
        user.setDisplayname("Novo usuário");
        user.setPassword("abc@123");
        userRepository.save(user);

    }
}
