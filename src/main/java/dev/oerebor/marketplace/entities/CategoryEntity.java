package dev.oerebor.marketplace.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_category")
public class CategoryEntity implements Serializable {
    
    @Serial
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    
    @JsonIgnore
    @ManyToMany(mappedBy = "categories")
    private Set<ProductEntity> products = new HashSet<>();
    
    public CategoryEntity() {
    
    }
    
    public CategoryEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Set<ProductEntity> getProducts() {
        return products;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CategoryEntity categoryEntity)) return false;
    
        return getId().equals(categoryEntity.getId());
    }
    
    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
