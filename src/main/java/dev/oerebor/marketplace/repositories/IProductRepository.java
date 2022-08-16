package dev.oerebor.marketplace.repositories;

import dev.oerebor.marketplace.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<ProductEntity, Long> {
}
