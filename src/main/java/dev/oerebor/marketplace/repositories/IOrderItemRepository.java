package dev.oerebor.marketplace.repositories;

import dev.oerebor.marketplace.entities.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderItemRepository extends JpaRepository<OrderItemEntity, Long> {

}
