package dev.oerebor.marketplace.repositories;

import dev.oerebor.marketplace.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<CategoryEntity, Long> {
}
