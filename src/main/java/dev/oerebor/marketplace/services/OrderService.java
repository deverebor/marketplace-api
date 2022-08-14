package dev.oerebor.marketplace.services;

import dev.oerebor.marketplace.entities.OrderEntity;
import dev.oerebor.marketplace.repositories.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    
    @Autowired
    private IOrderRepository orderRepository;
    
    public List<OrderEntity> findAll() {
        return orderRepository.findAll();
    }
    
    public OrderEntity findById(Long id) {
        Optional<OrderEntity> order = orderRepository.findById(id);
        
       return order.get();
    }
}
