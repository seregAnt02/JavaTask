package ru.gb.book_distribution.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.book_distribution.model.Book;
import ru.gb.book_distribution.repository.BookRepository;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class BookServices {

    private final BookRepository repository;

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
    }

}
