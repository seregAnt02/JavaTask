package ru.gb.book_distribution.app;

import com.sun.source.tree.LambdaExpressionTree;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.gb.book_distribution.model.Book;
import ru.gb.book_distribution.services.BookServices;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/book")
public class BookController {

    @Autowired
    private final BookServices services;

    public BookController(BookServices bookServices) {
        this.services = bookServices;
    }

    @GetMapping
    public List<Book> getAllNotes() {
        return services.getAllBooks();
    }

    @GetMapping(path = "/{id}")
    public Book getBookById(@PathVariable long id){
        Book book = this.services.getBookById(id);
        log.info("Получен запрос на описание книги: " + book);
        return book;
    }

    @PostMapping
    public Book crateBook(@RequestBody Book book){
        Book outBook = this.services.createBook(book);
        log.info("Создание книги: " + outBook);
        return outBook;
    }

    @PostMapping(path = "/{id}")
    public Book updateBook(@PathVariable long id, @RequestBody Book book){
        return this.services.updateBook(id, book);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteBook(@PathVariable Long id){
        Book book = this.services.deleteBook(id);
        if(book != null)
            log.info("Удаление книги из списка:" + id);
    }

    /*@Autowired
    private final BookServices services;

    public BookController(BookServices services) {
        this.services = services;
    }

    @GetMapping(path = "/{id}")
    public Book getBookById(@PathVariable long id){
        Book book = this.services.getBookById(id);
        log.info("Получен запрос на описание книги: " + book);
        return book;
    }


    @PostMapping
    public Book crateBook(@RequestBody Book book){
        Book outBook = this.services.createBook(book);
        log.info("Создание книги: " + outBook);
        return outBook;
    }

    @PostMapping(path = "/{id}")
    public Book updateBook(@PathVariable long id, @RequestBody Book book){
        return this.services.updateBook(id, book);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteBook(@PathVariable Long id){
        this.services.deleteBook(id);
        log.info("Удаление книги из списка:" + id);
    }*/
}
