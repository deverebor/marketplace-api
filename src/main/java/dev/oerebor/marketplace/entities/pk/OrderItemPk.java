package dev.oerebor.marketplace.entities.pk;

import dev.oerebor.marketplace.entities.OrderEntity;
import dev.oerebor.marketplace.entities.ProductEntity;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serial;
import java.io.Serializable;

@Embeddable
public class OrderItemPk implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;
    
    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;
    
    public OrderEntity getOrder() {
        return order;
    }
    
    public void setOrder(OrderEntity order) {
        this.order = order;
    }
    
    public ProductEntity getProduct() {
        return product;
    }
    
    public void setProduct(ProductEntity product) {
        this.product = product;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItemPk that)) return false;
    
        if (!getOrder().equals(that.getOrder())) return false;
        return getProduct().equals(that.getProduct());
    }
    
    @Override
    public int hashCode() {
        int result = getOrder().hashCode();
        result = 31 * result + getProduct().hashCode();
        return result;
    }
}
