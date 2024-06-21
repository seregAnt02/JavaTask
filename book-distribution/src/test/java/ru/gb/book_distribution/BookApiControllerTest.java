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
import ru.gb.book_distribution.repository.BookRepository;

import java.util.List;
import java.util.Objects;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
@RequiredArgsConstructor
class BookApiControllerTest {

	@Autowired
	WebTestClient webTestClient;

	/*@Autowired
	private StandardBookService services;*/

	@Autowired
	BookRepository bookRepository;

	@Data
	static class JUnitBookResponse {
		private long id;
		private String name;
	}

	/*@Test
	void testFindByIdNotFound(){
		Assumptions.assumeFalse(bookRepository.findById(-1L).isPresent());

		webTestClient.get()
				.uri("/book/-1")
				.exchange()
				.expectStatus().isNotFound();
	}*/
	@Test
	void testFindByIdSuccess(){
		Book expected = bookRepository.save(Book.ofName("random"));

		JUnitBookResponse responseBody = webTestClient.get()
				.uri("/book/" + expected.getId())
				.exchange()
				.expectStatus().isOk()
				.expectBody(JUnitBookResponse.class)
				.returnResult()
				.getResponseBody();

		Assertions.assertNotNull(responseBody);
		Assertions.assertEquals(expected.getId(), responseBody.getId());
		Assertions.assertEquals(expected.getName(), responseBody.getName());
	}

	@Test
	void testGetAll() {
		//подготовка данных
		List<Book> expected = bookRepository.saveAll(List.of(
				new Book("name1"),
				new Book("name2"),
				new Book("random")
		));

		List<JUnitBookResponse> responseBody = webTestClient.get()
				.uri("/book")
				.exchange()
				.expectStatus().isOk()
				.expectBody(new ParameterizedTypeReference<List<JUnitBookResponse>>(){})
				.returnResult()
				.getResponseBody();

		Assertions.assertEquals(expected.size(), responseBody.size());

		for (JUnitBookResponse bookResponse : responseBody){
			boolean found = expected.stream()
					.filter(it -> Objects.equals(it.getId(), bookResponse.getId()))
					.anyMatch(it -> Objects.equals(it.getName(), bookResponse.getName()));
			Assertions.assertTrue(found);
		}

	}

}
