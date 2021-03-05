package se.lexicon.jpa_workshop.entity;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ProductOrderTest {

    ProductOrder testObject; //Global variable
    AppUser mikaelCustomer;
    List<OrderItem> orderItemTestList;

    //ProductOrder productOrderTest;

    OrderItem orderItemTest1;
    OrderItem orderItemTest2;
    OrderItem orderItemTest3;

    @BeforeEach
    public void setup(){
        testObject= new ProductOrder();

        //Create AppUser------------------------
        mikaelCustomer = new AppUser();
        mikaelCustomer.setFirstName("Mikael");
        mikaelCustomer.setLastName("Aurell");
        mikaelCustomer.setEmail("m.a@gmail.com");
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
        //--------------------------------------------

        //Create orderItemTestList
        orderItemTestList = new ArrayList<>();
        orderItemTestList.add(orderItemTest1);
        orderItemTestList.add(orderItemTest2);
        orderItemTestList.add(orderItemTest3);



        //Add ProductOrder Setup---------------------------------
        testObject.setCustomer(mikaelCustomer);
        testObject.setOrderDateTime(LocalDateTime.now());
        //testObject.addOrderItem(orderItemTest1);
        testObject.addOrderItem(orderItemTest1);
        testObject.addOrderItem(orderItemTest2);



    }

    @Test
    @DisplayName("Test 1: Create Customer")
    public void test1(){

        Assertions.assertEquals("Mikael", testObject.getCustomer().getFirstName());
    }

    @Test
    @DisplayName("Test 2: SetOrderItems")
    public void test2(){

        testObject.setOrderItems(orderItemTestList);

        Assertions.assertEquals("A", testObject.getOrderItems().get(0).getProduct().getName());
    }

    @Test
    @DisplayName("Test 3: Method AddOrderItem")
    public void test3(){

        //testObject.addOrderItem(orderItemTest1);
        //testObject.addOrderItem(orderItemTest2);

        Assertions.assertEquals("B", testObject.getOrderItems().get(1).getProduct().getName());
    }


    @Test
    @DisplayName("Test 4: Method RemoveOrderItem")
    public void test4(){
        //testObject.addOrderItem(orderItemTest2);
        testObject.removeOrderItem(orderItemTest1); //Todo: removeOrderItem dosent work

        Assertions.assertEquals("B", testObject.getOrderItems().get(1).getProduct().getName());
    }

    @Test
    @DisplayName("Test 5: CalculateTotalPrice")
    public void test5(){


        //testObject.addOrderItem(orderItemTest2);
        Assertions.assertEquals(2900, testObject.calculateTotalPrice(testObject.getOrderItems()));
    }
}
