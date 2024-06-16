package ru.gb.api;

import com.github.javafaker.Faker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.model.Author;
import ru.gb.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class BookController {

    private Faker faker;
    private final List<Book> books;

    public BookController() {
        this.faker = new Faker();

        this.books = new ArrayList<>();

        for (int i = 0; i < 15; i++){
            Book book = new Book();
            book.setId(UUID.randomUUID());
            book.setName(faker.book().title());

            Author author = new Author();
            author.setId(UUID.randomUUID());
            author.setFirstName(faker.name().firstName());
            author.setLastName(faker.name().lastName());

            book.setAuthor(author);

            books.add(book);
        }
        List.copyOf(books);
    }

    @GetMapping("/book")
    public List<Book> all(){
        return books;
    }

    @GetMapping("/random")
    public Book getRandom(){
        final int randomIndex = faker.number().numberBetween(0, books.size());
        return books.get(randomIndex);
    }
}
