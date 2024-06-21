package ru.gb.book_distribution.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "books")
@Data
@RequiredArgsConstructor
public class Book {
    private static long sequence = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;

    public Book(String name) {
        this(sequence++, name);
    }

    public Book(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Book ofName(String name){
        Book book = new Book();
        book.setId(3L);
        book.setName(name);
        return book;
    }
}
