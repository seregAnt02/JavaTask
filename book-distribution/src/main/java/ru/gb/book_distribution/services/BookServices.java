package ru.gb.book_distribution.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.book_distribution.model.Book;
import ru.gb.book_distribution.repository.BookRepository;
import ru.gb.book_distribution.repository.IBookRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookServices implements IBookServices{

    @Autowired
    private IBookRepository repository;
    @Override
    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    @Override
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

    @Override
    public Book updateBook(Long id, Book book) {
        Book existBook = getBookById(id);
        existBook.setName(book.getName());
        return existBook;
    }

    @Override
    public Book deleteBook(Long id) {
        Book book = getBookById(id);
        if(book != null){
            repository.findAll().removeIf(it -> Objects.equals(it.getId(), id));
        }
        return book;
    }

   /* private final BookRepository repository;

    public List<Book> getAllByBook(){
        return repository.getAll();
    }
    public Book getBookById(long id){
        return repository.getAll().stream()
                .filter(it -> Objects.equals(it.getId(), id))
                .findFirst()
                .orElse(null);
    }

    public Book createBook(Book book){
        Book outBook = new Book(book.getName());
        repository.getAll().add(outBook);
        return outBook ;
    }
    public Book updateBook(long id, Book book){
        Book existBook = getBookById(id);
        existBook.setName(book.getName());
        return existBook;
    }


    public void deleteBook(long id){
        Book book = getBookById(id);
        if(book != null){
            repository.getAll().removeIf(it -> Objects.equals(it.getId(), id));
        }
    }*/

}
