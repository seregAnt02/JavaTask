package ru.gb.book_distribution.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "issues")
@Data
public class Issue {
    private static long sequence = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "bookId")
    private long bookId;

    @Column(name = "readerId")
    private long readerId;

    @Column(name = "nameBook")
    private String nameBook;

    @Column(name = "nameRead")
    private String nameRead;

    @Column(name = "startTimestamp")
    private String startTimestamp;

    @Column(name = "endTimestamp")
    private String endTimestamp;

    public Issue() {
    }

    public Issue(long bookId, long readerId) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        this.id = sequence++;
        this.bookId = bookId;
        this.readerId = readerId;
        this.startTimestamp = dtf.format(LocalDateTime.now());
        this.endTimestamp = "";
    }

    public static Issue ofName(long bookId, long readerId){
        Issue issue = new Issue();
        issue.setId(1L);
        issue.setBookId(bookId);
        issue.setReaderId(readerId);
        return issue;
    }
}
