package ru.gb.book_distribution.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "issues")
@RequiredArgsConstructor
@Data
public class Issue {
    private static long sequence = 1L;
    @Id
    private final long id;
    @Column(name = "bookId")
    private final long bookId;
    @Column(name = "readerId")
    private final long readerId;
    @Column(name = "nameBook")
    private String nameBook;
    @Column(name = "nameRead")
    private String nameRead;
    @Column(name = "startTimestamp")
    private String startTimestamp;
    @Column(name = "endTimestamp")
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
