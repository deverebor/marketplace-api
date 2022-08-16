package dev.oerebor.marketplace.resources;

import dev.oerebor.marketplace.entities.ProductEntity;
import dev.oerebor.marketplace.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductResource {
    
    @Autowired
    private ProductService productService;
    
    @GetMapping
    public ResponseEntity<List<ProductEntity>> findAll() {
        List<ProductEntity> userList = productService.findAll();
        
        return ResponseEntity.ok().body(userList);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ProductEntity> findById(@PathVariable Long id) {
        ProductEntity user = productService.findById(id);
        
        return ResponseEntity.ok().body(user);
    }
}
