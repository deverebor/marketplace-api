package dev.oerebor.marketplace.repositories;

import dev.oerebor.marketplace.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<OrderEntity, Long> {
}
