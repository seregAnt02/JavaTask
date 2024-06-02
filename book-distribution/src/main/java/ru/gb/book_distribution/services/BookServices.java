package ru.gb.book_distribution.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.book_distribution.model.Book;
import ru.gb.book_distribution.repository.BookRepository;
import ru.gb.book_distribution.repository.IBookRepository;

import java.util.List;
import java.util.Objects;

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
        return repository.findById(id).get();
    }

    public Book createBook(Book book){
        Book outBook = new Book(book.getName());
        repository.findAll().add(outBook);
        return outBook ;
    }

    @Override
    public Book updateBook(Long id, Book book) {
        Book existBook = getBookById(id);
        existBook.setName(book.getName());
        return existBook;
    }

    @Override
    public void deleteBook(Long id) {
        Book book = getBookById(id);
        if(book != null){
            repository.findAll().removeIf(it -> Objects.equals(it.getId(), id));
        }
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
