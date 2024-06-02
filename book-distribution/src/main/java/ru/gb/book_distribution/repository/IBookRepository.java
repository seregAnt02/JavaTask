package ru.gb.book_distribution.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.book_distribution.model.Book;

import java.util.List;

@Repository
public interface IBookRepository extends JpaRepository<Book, Long> {
    List<Book> findByName(String name);

}
