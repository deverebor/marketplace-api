package dev.oerebor.marketplace.resources;

import dev.oerebor.marketplace.entities.UserEntity;
import dev.oerebor.marketplace.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResource {
    
    @Autowired
    private UserService userService;
    
    @GetMapping
    public ResponseEntity<List<UserEntity>> findAll() {
        List<UserEntity> userList = userService.findAll();
        
        return ResponseEntity.ok().body(userList);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> findById(@PathVariable Long id) {
        UserEntity user = userService.findById(id);
        
        return ResponseEntity.ok().body(user);
    }
}
