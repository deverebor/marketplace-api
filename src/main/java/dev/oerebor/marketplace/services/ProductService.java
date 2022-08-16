package dev.oerebor.marketplace.services;

import dev.oerebor.marketplace.entities.ProductEntity;
import dev.oerebor.marketplace.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    
    @Autowired
    private IProductRepository productRepository;
    
    public List<ProductEntity> findAll() {
        return productRepository.findAll();
    }
    
    public ProductEntity findById(Long id) {
        Optional<ProductEntity> product = productRepository.findById(id);
        
       return product.get();
    }
}
