package se.lexicon.jpa_workshop.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductTest {

    @Test
    @DisplayName("Test 1: Save Product")
    public void Test1(){
        Product productTest = new Product();
        productTest.setName("A");
        productTest.setPrice(300);

        //Assertions.assertEquals("A",productTest.getName());
        Assertions.assertEquals(300,productTest.getPrice());
    }

}
