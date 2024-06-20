package ru.gb.seminar1.beans;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;



@SpringBootTest(
        classes = {
                AutoService.class,
                Auto.class
        }
)
//@SpringBootTest(classes = AutoServiceTest.TestConfig.class)
public class AutoServiceTest {

   /* @TestConfiguration
    static class TestConfig {

        @Bean
        AutoService autoService(Auto auto){
            return new AutoService(auto);
        }

        @Bean
        Auto auto(){
            return Mockito.mock(Auto.class);
        }

    }*/

    @Autowired
    AutoService autoService;

    @MockBean
    Auto auto;

    @Test
    void testChangeWheelsInOk(){
        Mockito.doNothing().when(auto).changeWheels();
        Assertions.assertTrue(autoService.changeWheelsIn());
    }

    @Test
    void testChangeWheelsInError(){
        Mockito.doThrow(RuntimeException.class).when(auto).changeWheels();
        Assertions.assertFalse(autoService.changeWheelsIn());
    }
}
