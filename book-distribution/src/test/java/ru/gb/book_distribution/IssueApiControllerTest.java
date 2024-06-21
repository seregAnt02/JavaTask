package ru.gb.book_distribution;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;
import ru.gb.book_distribution.model.Book;
import ru.gb.book_distribution.model.Issue;
import ru.gb.book_distribution.repository.IssueRepository;

import java.util.List;
import java.util.Objects;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
@RequiredArgsConstructor
public class IssueApiControllerTest {
    @Autowired
    WebTestClient webTestClient;

    @Autowired
    IssueRepository repository;

    @Data
    static class JUnitIssueResponse {
        private long bookId;
        private long readerId;
    }

    @Test
    void testFindByIdSuccess(){
        Issue expected = repository.save(Issue.ofName(1L, 1L));

        IssueApiControllerTest.JUnitIssueResponse responseBody = webTestClient.get()
                .uri("/issue/1")
                .exchange()
                .expectStatus().isOk()
                .expectBody(IssueApiControllerTest.JUnitIssueResponse.class)
                .returnResult()
                .getResponseBody();

        Assertions.assertNotNull(responseBody);
        Assertions.assertEquals(expected.getBookId(), responseBody.bookId);
    }


    @Test
    void testGetAll() {
        //подготовка данных
        List<Issue> expected = repository.saveAll(List.of(
                new Issue(1L,1L),
                new Issue(2L,2L)
        ));

        List<JUnitIssueResponse> responseBody = webTestClient.get()
                .uri("/issue/all")
                .exchange()
                .expectStatus().isOk()
                .expectBody(new ParameterizedTypeReference<List<JUnitIssueResponse>>(){})
                .returnResult()
                .getResponseBody();

        Assertions.assertEquals(expected.size(), responseBody.size());

        for (JUnitIssueResponse bookResponse : responseBody){
            boolean found = expected.stream()
                    .filter(it -> Objects.equals(it.getId(), bookResponse.getBookId()))
                    .anyMatch(it -> Objects.equals(it.getBookId(), bookResponse.getBookId()));
            Assertions.assertTrue(found);
        }

    }
}
