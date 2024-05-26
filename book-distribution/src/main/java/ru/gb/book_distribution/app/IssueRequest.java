package ru.gb.book_distribution.app;

import lombok.Data;

@Data
public class IssueRequest {
    private long readId;
    private long bookId;
}
