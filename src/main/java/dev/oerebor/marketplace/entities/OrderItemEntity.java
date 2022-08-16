package dev.oerebor.marketplace.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.oerebor.marketplace.entities.pk.OrderItemPk;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "tb_order_item")
public class OrderItemEntity implements Serializable {
    
    @Serial
    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    private final OrderItemPk id = new OrderItemPk();
    private Integer quantity;
    private Double price;
    
    public OrderItemEntity() {
    }
    
    public OrderItemEntity(OrderEntity order, ProductEntity product, Integer quantity, Double price) {
        super();
        id.setOrder(order);
        id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }
    
    public Integer getQuantity() {
        return quantity;
    }
    
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    
    public Double getPrice() {
        return price;
    }
    
    public void setPrice(Double price) {
        this.price = price;
    }
    
    @JsonIgnore
    public OrderEntity getOrder() {
        return id.getOrder();
    }
    
    public void setOrder(OrderEntity order) {
        id.setOrder(order);
    }
    
    public ProductEntity getProduct() {
        return id.getProduct();
    }
    
    public void setProduct(ProductEntity product) {
        id.setProduct(product);
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItemEntity that)) return false;
    
        return id.equals(that.id);
    }
    
    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
