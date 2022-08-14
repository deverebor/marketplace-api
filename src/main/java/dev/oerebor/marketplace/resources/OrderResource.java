package dev.oerebor.marketplace.resources;

import dev.oerebor.marketplace.entities.OrderEntity;
import dev.oerebor.marketplace.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderResource {
    
    @Autowired
    private OrderService orderService;
    
    @GetMapping
    public ResponseEntity<List<OrderEntity>> findAll() {
        List<OrderEntity> orderList = orderService.findAll();
        
        return ResponseEntity.ok().body(orderList);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<OrderEntity> findById(@PathVariable Long id) {
        OrderEntity order = orderService.findById(id);
        
        return ResponseEntity.ok().body(order);
    }
}
