package se.lexicon.jpa_workshop.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class OrderItemTest {
    @Test
    @DisplayName("Test 1: Save OrderItem")
    public void test1() {
        OrderItem orderItemTest = new OrderItem();
        Product productTest = new Product();
        productTest.setName("B");
        productTest.setPrice(300);
        orderItemTest.setQuantity(5);
        orderItemTest.setProduct(productTest);
        orderItemTest.setProductOrder(null);

        Assertions.assertEquals(productTest, orderItemTest.getProduct());
        Assertions.assertEquals(5, orderItemTest.getQuantity());

        Assertions.assertEquals(1500,orderItemTest.calculatePrice(productTest, orderItemTest.getQuantity()));

    }
}
