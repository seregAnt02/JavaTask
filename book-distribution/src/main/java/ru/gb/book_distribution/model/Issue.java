package ru.gb.book_distribution.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class Issue {
    private static long sequence = 1L;
    private final long id;
    private final long bookId;
    private final long readerId;
    private String nameBook;
    private String nameRead;
    private String startTimestamp;
    private String endTimestamp;

    public Issue(long bookId, long readerId) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        this.id = sequence++;
        this.bookId = bookId;
        this.readerId = readerId;
        this.startTimestamp = dtf.format(LocalDateTime.now());
        this.endTimestamp = "";
    }
}
