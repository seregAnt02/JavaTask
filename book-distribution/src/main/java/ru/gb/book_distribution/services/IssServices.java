package ru.gb.book_distribution.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.book_distribution.app.IssueRequest;
import ru.gb.book_distribution.model.Issue;
import ru.gb.book_distribution.repository.BookRepository;
import ru.gb.book_distribution.repository.IssueRepository;
import ru.gb.book_distribution.repository.ReaderRepository;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class IssServices {
    private final BookRepository bookRepository;
    private final ReaderRepository readerRepository;
    private final IssueRepository issueRepository;
    public Issue issue(IssueRequest request){
        if(bookRepository.getBookById(request.getBookId()) == null){
            throw new NoSuchElementException("Не найдена книга с идентификатором: " + request.getBookId());
        }
        if(readerRepository.getReaderById(request.getReadId()) == null){
            throw new NoSuchElementException("Не найдена читатель с идентификатором: " + request.getReadId());
        }

        Issue issue = new Issue(request.getBookId(),request.getReadId());
        issueRepository.save(issue);
        return issue;
    }
}
