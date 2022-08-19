package dev.oerebor.marketplace.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "tb_payment")
public class PaymentEntity implements Serializable {
    
    @Serial
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant createdAt;
    
    @JsonIgnore
    @OneToOne
    @MapsId
    private OrderEntity order;
    
    public PaymentEntity() {
    
    }
    
    public PaymentEntity(Long id, Instant createdAt, OrderEntity order) {
        super();
        this.id = id;
        this.createdAt = createdAt;
        this.order = order;
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
    
    public OrderEntity getOrder() {
        return order;
    }
    
    public void setOrder(OrderEntity order) {
        this.order = order;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PaymentEntity that)) return false;
    
        return getId().equals(that.getId());
    }
    
    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
