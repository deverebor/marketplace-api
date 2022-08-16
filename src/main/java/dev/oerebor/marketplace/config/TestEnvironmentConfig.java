package dev.oerebor.marketplace.config;

import dev.oerebor.marketplace.entities.*;
import dev.oerebor.marketplace.entities.enums.OrderStatus;
import dev.oerebor.marketplace.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestEnvironmentConfig implements CommandLineRunner {
    
    @Autowired
    private IUserRepository userRepository;
    
    @Autowired
    private IOrderRepository orderRepository;
    
    @Autowired
    private ICategoryRepository categoryRepository;
    
    @Autowired
    private IProductRepository productRepository;
    
    @Autowired
    private IOrderItemRepository orderItemRepository;
    
    @Override
    public void run(String... args) throws Exception {
        UserEntity u1 = new UserEntity(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        UserEntity u2 = new UserEntity(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
    
        OrderEntity o1 = new OrderEntity(null, Instant.parse("2022-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        OrderEntity o2 = new OrderEntity(null, Instant.parse("2022-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
        OrderEntity o3 = new OrderEntity(null, Instant.parse("2022-08-07T07:07:07Z"), OrderStatus.WAITING_PAYMENT, u1);
    
        CategoryEntity cat1 = new CategoryEntity(null, "Electronics");
        CategoryEntity cat2 = new CategoryEntity(null, "Books");
        CategoryEntity cat3 = new CategoryEntity(null, "Computers");
    
        ProductEntity p1 = new ProductEntity(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        ProductEntity p2 = new ProductEntity(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        ProductEntity p3 = new ProductEntity(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        ProductEntity p4 = new ProductEntity(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        ProductEntity p5 = new ProductEntity(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
    
        OrderItemEntity oi1 = new OrderItemEntity(o1, p1, 2, p1.getPrice());
        OrderItemEntity oi2 = new OrderItemEntity(o1, p3, 1, p3.getPrice());
        OrderItemEntity oi3 = new OrderItemEntity(o2, p3, 2, p3.getPrice());
        OrderItemEntity oi4 = new OrderItemEntity(o3, p5, 2, p5.getPrice());
        
        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
        
        // Adding mock in categories
        p1.getCategories().add(cat2);
        
        p2.getCategories().add(cat1);
        p2.getCategories().add(cat3);
        
        p3.getCategories().add(cat3);
        
        p4.getCategories().add(cat3);
        
        p5.getCategories().add(cat2);
        
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
        orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
    }
}
