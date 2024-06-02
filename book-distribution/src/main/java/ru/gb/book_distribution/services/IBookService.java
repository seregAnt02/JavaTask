package ru.gb.book_distribution.services;

import ru.gb.book_distribution.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> getAllBooks();
    Book getBookById(Long id);
    Book createBook(Book book);
    Book updateBook(Long id, Book book);
    Book deleteBook(Long id);
}
