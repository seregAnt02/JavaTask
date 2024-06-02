package ru.gb.book_distribution;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.gb.book_distribution.model.Book;
import ru.gb.book_distribution.repository.IBookRepository;

@SpringBootApplication
public class BookDistributionApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context	= SpringApplication.run(BookDistributionApplication.class, args);

		/*IBookRepository bookRepository = context.getBean(IBookRepository.class);

		Book book = new Book();
		book.setId(1L);
		book.setName("Tom");
		bookRepository.save(book);

		Book book1 = new Book();
		book1.setId(2L);
		book1.setName("Jerry");
		bookRepository.save(book1);

		System.out.println("findByName" + bookRepository.findByName("Tom"));
		System.out.println("findById: " + bookRepository.findById(1L).get());*/
	}

}
