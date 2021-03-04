package se.lexicon.jpa_workshop.entity;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ProductOrderTest {

    @Autowired
    ProductOrder productOrderTest;
    List<OrderItem> expectedItemList;

    @BeforeEach
    public void setup(){

        //Create AppUser------------------------
        AppUser appUserTest = new AppUser();
        appUserTest.setFirstName("Mikael");
        appUserTest.setLastName("Aurell");
        appUserTest.setEmail("m.a@gmail.com");
        //------------------------------------

        //Create Products------------------------
        Product productTest1 = new Product();
        productTest1.setName("A");
        productTest1.setPrice(500);

        Product productTest2 = new Product();
        productTest2.setName("B");
        productTest2.setPrice(200);

        Product productTest3 = new Product();
        productTest3.setName("C");
        productTest3.setPrice(100);
        //------------------------------------

        //Create OrderItems---------------------------
        OrderItem orderItemTest1 = new OrderItem();
        orderItemTest1.setProduct(productTest1);
        orderItemTest1.setQuantity(5);

        OrderItem orderItemTest2 = new OrderItem();
        orderItemTest2.setProduct(productTest2);
        orderItemTest2.setQuantity(2);

        OrderItem orderItemTest3 = new OrderItem();
        orderItemTest3.setProduct(productTest3);
        orderItemTest3.setQuantity(10);

        List<OrderItem> expectedItemList = new ArrayList<>();
        expectedItemList.add(orderItemTest1);
        expectedItemList.add(orderItemTest2);
        expectedItemList.add(orderItemTest3);

        //Add ProductOrder---------------------------------
        ProductOrder productOrderTest = new ProductOrder();

        //testProductObject.addOrderItem(orderItemTest1); //Todo: check addOrderItem method not working
        //testProductObject.addOrderItem(orderItemTest2);
        //testProductObject.addOrderItem(orderItemTest3);

        productOrderTest.setCustomer(appUserTest);
        productOrderTest.setOrderDateTime(LocalDateTime.now());
        productOrderTest.setOrderItems(expectedItemList);
        //-------------------------------------------------

    }

    @Test
    @DisplayName("Test 1: Create ProductOrder")
    public void test1(){

        Assertions.assertEquals(expectedItemList, productOrderTest.getOrderItems());

    }
}
