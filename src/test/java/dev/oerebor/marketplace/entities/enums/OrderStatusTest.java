package dev.oerebor.marketplace.entities.enums;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderStatusTest {
    private OrderStatus orderStatus;
    
    
    @Test
    public void shouldValueReturnCorrectOrderStatus() {
        orderStatus = OrderStatus.valueOf(1);
        assertEquals(orderStatus, OrderStatus.WAITING_PAYMENT);
    }
    
    @Test
    public void shoulReturnIlllegalArgumentExceptionWhenInvalidOrderStatusCode() {
        try {
            orderStatus = OrderStatus.valueOf(6);
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid OrderStatus code: 6", e.getMessage());
        }
    }
}
