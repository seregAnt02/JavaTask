package ru.gb.book_distribution.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Issue {
    private static long sequence = 1L;
    private final long id;
    private final long bookId;
    private final long readerId;
    private final LocalDateTime timestamp;

    public Issue(long bookId, long readerId) {
        this.id = sequence++;
        this.bookId = bookId;
        this.readerId = readerId;
        this.timestamp = LocalDateTime.now();
    }
}
