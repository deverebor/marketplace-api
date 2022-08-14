package dev.oerebor.marketplace.config;

import dev.oerebor.marketplace.entities.UserEntity;
import dev.oerebor.marketplace.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestEnvironmentConfig implements CommandLineRunner {
    
    @Autowired
    private IUserRepository userRepository;
    
    @Override
    public void run(String... args) throws Exception {
        UserEntity u1 = new UserEntity(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        UserEntity u2 = new UserEntity(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
        
        userRepository.saveAll(Arrays.asList(u1, u2));
    }
}
