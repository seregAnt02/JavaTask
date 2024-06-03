package ru.gb.book_distribution.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.book_distribution.model.Issue;

@Repository
public interface IssueRepository extends JpaRepository<Issue, Long> {

}
