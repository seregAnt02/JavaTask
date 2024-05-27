package ru.gb.book_distribution.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import ru.gb.book_distribution.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class BookRepository {
    private final List<Book> books;

    public BookRepository() {
        this.books = new ArrayList<>();
    }

    @PostConstruct
    public void generateDate(){
        books.addAll(List.of(
                new Book("Book1"),
                new Book("Book2"),
                new Book("Book3")
        ));
    }

    public  List<Book> getAll(){
        return books;
    }

}
