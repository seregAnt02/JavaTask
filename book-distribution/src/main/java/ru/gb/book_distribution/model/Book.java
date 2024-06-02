package ru.gb.book_distribution.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "books")
@Data
@RequiredArgsConstructor
public class Book {
    private static long sequence = 1L;
    @Id
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
}
