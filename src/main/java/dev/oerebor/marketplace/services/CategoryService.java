package dev.oerebor.marketplace.services;

import dev.oerebor.marketplace.entities.CategoryEntity;
import dev.oerebor.marketplace.repositories.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    
    @Autowired
    private ICategoryRepository categoryRepository;
    
    public List<CategoryEntity> findAll() {
        return categoryRepository.findAll();
    }
    
    public CategoryEntity findById(Long id) {
        Optional<CategoryEntity> user = categoryRepository.findById(id);
        
       return user.get();
    }
}
