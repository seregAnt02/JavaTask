package ru.gb.seminar2.api;

import lombok.Data;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;
import ru.gb.seminar2.model.Customer;
import ru.gb.seminar2.repository.CustomRepository;

import java.util.List;
import java.util.Objects;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class CustomerControllerTest {
    @Autowired
    WebTestClient webTestClient;

    @Autowired
    CustomRepository customRepository;

    /*@LocalServerPort
    int port;*/

    @Data
    static class JUnitCustomerResponse {
        private Long id;
        private String name;
    }

    @Test
    void testGetAll(){
        //подготовка данных
         List<Customer> expected = customRepository.saveAll(List.of(
                new Customer("first"),
                new Customer("last")
        ));

        List<JUnitCustomerResponse> responseBody = webTestClient.get()
                .uri("/api/customer")
                .exchange()
                .expectStatus().isOk()
                .expectBody(new ParameterizedTypeReference<List<JUnitCustomerResponse>>(){})
                .returnResult()
                .getResponseBody();


        Assertions.assertEquals(expected.size(), responseBody.size());
        for (JUnitCustomerResponse customerResponse : responseBody){
            boolean found = expected.stream()
                    .filter(it -> Objects.equals(it.getId(), customerResponse.getId()))
                    .anyMatch(it -> Objects.equals(it.getName(), customerResponse.getName()));
            Assertions.assertTrue(found);
        }
    }


}
