package se.lexicon.jpa_workshop.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AppUserTest {

    @Test
    @DisplayName("Test 1: Save AppUser")
    public void test1(){
        AppUser appUserTest = new AppUser();
        appUserTest.setFirstName("Mikael");
        appUserTest.setLastName("Aurell");
        appUserTest.setEmail("mikael.aurell@gmail.com");

        //Assertions.assertEquals("Mikael", appUserTest.getFirstName());
        //Assertions.assertEquals("Aurell", appUserTest.getLastName());
        Assertions.assertEquals("mikael.aurell@gmail.com", appUserTest.getEmail());

    }
}
