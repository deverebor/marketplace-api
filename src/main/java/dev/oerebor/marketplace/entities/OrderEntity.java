package dev.oerebor.marketplace.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

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
    @ManyToOne
    @JoinColumn(name = "client_id")
    private UserEntity client;
    
    public OrderEntity() {}
    
    public OrderEntity(Long id, Instant createdAt, UserEntity client) {
        super();
        this.id = id;
        this.createdAt = createdAt;
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
    
    public UserEntity getClient() {
        return client;
    }
    
    public void setClient(UserEntity client) {
        this.client = client;
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
