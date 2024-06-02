package ru.gb.book_distribution.services;

import ru.gb.book_distribution.model.Issue;
import ru.gb.book_distribution.model.IssueRequest;

import java.util.List;

public interface IIssServices {
    public Issue getIssById(Long id);
    public Issue createIssue(IssueRequest request);
    public List<Issue> getAll();
    public Issue deleteIssue(Long id);
}
