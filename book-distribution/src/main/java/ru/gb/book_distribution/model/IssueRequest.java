package ru.gb.book_distribution.model;

import lombok.Data;

@Data
public class IssueRequest {
    private long readId;
    private long bookId;
}
