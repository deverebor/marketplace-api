package dev.oerebor.marketplace.resources;

import dev.oerebor.marketplace.entities.UserEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserResource {
    
    @GetMapping
    public ResponseEntity<UserEntity> findAll() {
        UserEntity user = new UserEntity(1L, "John Doe", "jhondoe@email.com", "1234567890", "123");
        
        return ResponseEntity.ok().body(user);
    }
}
