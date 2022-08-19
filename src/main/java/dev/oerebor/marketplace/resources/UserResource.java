package dev.oerebor.marketplace.resources;

import dev.oerebor.marketplace.entities.UserEntity;
import dev.oerebor.marketplace.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    
    @PostMapping
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user) {
        UserEntity createdUser = userService.createUser(user);
    
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdUser.getId()).toUri();
        
        return ResponseEntity.created(uri).body(createdUser);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        
        return ResponseEntity.noContent().build();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<UserEntity> updateUser(@PathVariable Long id, @RequestBody UserEntity user) {
        UserEntity updatedUser = userService.updateUser(id, user);
        
        return ResponseEntity.ok().body(updatedUser);
    }
}
