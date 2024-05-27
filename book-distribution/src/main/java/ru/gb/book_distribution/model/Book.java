package ru.gb.book_distribution.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Book {
    private static long sequence = 1L;
    private long id;
    private String name;

    public Book(String name) {
        this(sequence++, name);
    }

    public Book(long id, String name) {
        this.id = id;
        this.name = name;
    }
}
