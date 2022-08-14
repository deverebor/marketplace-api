package dev.oerebor.marketplace.resources;

import dev.oerebor.marketplace.entities.CategoryEntity;
import dev.oerebor.marketplace.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryResource {
    
    @Autowired
    private CategoryService categoryService;
    
    @GetMapping
    public ResponseEntity<List<CategoryEntity>> findAll() {
        List<CategoryEntity> userList = categoryService.findAll();
        
        return ResponseEntity.ok().body(userList);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<CategoryEntity> findById(@PathVariable Long id) {
        CategoryEntity user = categoryService.findById(id);
        
        return ResponseEntity.ok().body(user);
    }
}
