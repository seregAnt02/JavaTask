package ru.gb.book_distribution.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.book_distribution.model.Book;
import ru.gb.book_distribution.repository.BookRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

@Slf4j
@Service
public class StandardBookService{

    private BookRepository repository;

    public StandardBookService(BookRepository repository) {
        this.repository = repository;

        Book book = new Book();
        book.setName("name1");
        this.repository.save(book);

        Book book1 = new Book();
        book1.setName("name2");
        this.repository.save(book1);

        /*Book book2 = new Book();
        book2.setId(-1);
        book2.setName("random");
        this.repository.save(book2);*/

        Book bookRandom = new Book();
        bookRandom.setName("random");
        this.repository.save(bookRandom);
    }

    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    public Book getBookById(Long id) {
        Book book = null;
        try {
           book = repository.findById(id).get();
        }catch (NoSuchElementException ex){
            ex.getStackTrace();
        }
        return book;
    }

    public Book createBook(Book book){
        Book outBook = new Book(book.getName());
        repository.save(outBook);
        return outBook ;
    }


    public Book updateBook(Long id, Book book) {
        Book existBook = getBookById(id);
        existBook.setName(book.getName());
        return existBook;
    }

    public Book deleteBook(Long id) {
        Book book = getBookById(id);
        if(book != null){
            repository.findAll().removeIf(it -> Objects.equals(it.getId(), id));
        }
        return book;
    }

}
