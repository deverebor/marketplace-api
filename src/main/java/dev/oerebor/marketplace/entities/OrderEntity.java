package dev.oerebor.marketplace.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.oerebor.marketplace.entities.enums.OrderStatus;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_order")
public class OrderEntity implements Serializable {
    
    @Serial
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant createdAt;
    
    private Integer orderStatus;
    
    @ManyToOne
    @JoinColumn(name = "client_id")
    private UserEntity client;
    
    @OneToMany(mappedBy = "id.order")
    private Set<OrderItemEntity> items = new HashSet<>();
    
    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private PaymentEntity payment;
    
    public OrderEntity() {}
    
    public OrderEntity(Long id, Instant createdAt, OrderStatus orderStatus, UserEntity client) {
        super();
        this.id = id;
        this.createdAt = createdAt;
        setOrderStatus(orderStatus);
        this.client = client;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Instant getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
    
    public OrderStatus getOrderStatus() {
        return OrderStatus.valueOf(orderStatus);
    }
    
    public Set<OrderItemEntity> getItems() {
        return items;
    }
    
    public PaymentEntity getPayment() {
        return payment;
    }
    
    public void setPayment(PaymentEntity payment) {
        this.payment = payment;
    }
    
    public void setOrderStatus(OrderStatus orderStatus) {
        if(orderStatus != null) {
            this.orderStatus = orderStatus.getCode();
        }
    }
    
    public UserEntity getClient() {
        return client;
    }
    
    public void setClient(UserEntity client) {
        this.client = client;
    }
    
    public Double getOrdersTotals() {
        double orderTotal = 0.0;
        
        for(OrderItemEntity item : items) {
            orderTotal += item.getSubTotal();
        }
        
        return orderTotal;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderEntity that)) return false;
    
        return getId().equals(that.getId());
    }
    
    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
