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
@RequiredArgsConstructor
public class StandardBookService{

    @Autowired
    private BookRepository repository;

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
