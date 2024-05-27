package ru.gb.book_distribution.repository;

import org.springframework.stereotype.Repository;
import ru.gb.book_distribution.model.Issue;

import java.util.ArrayList;
import java.util.List;

@Repository
public class IssueRepository {
    private final List<Issue> issues;

    public IssueRepository() {
        this.issues = new ArrayList<>();
    }

    public void save(Issue issue){
        issues.add(issue);
    }

    public List<Issue> getAll(){
        return issues;
    }
}
