package ru.gb.book_distribution.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.book_distribution.model.Book;
import ru.gb.book_distribution.model.IssueRequest;
import ru.gb.book_distribution.model.Issue;
import ru.gb.book_distribution.model.Reader;
import ru.gb.book_distribution.repository.IssueRepository;
import ru.gb.book_distribution.repository.ReaderRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class IssServices {
    private final BookServices services;
    private final ReaderRepository readerRepository;
    private final IssueRepository repository;


    public Issue getIssById(long id){
        return repository.getAll().stream()
                .filter(it -> Objects.equals(it.getId(), id))
                .findFirst()
                .orElse(null);
    }

    public Issue createIssue(IssueRequest request){
        Book book = services.getBookById(request.getBookId());
        if(book == null){
            throw new NoSuchElementException("Не найдена книга с идентификатором: " + request.getBookId());
        }
        Reader reader = readerRepository.getReaderById(request.getReadId());
        if(reader == null){
            throw new NoSuchElementException("Не найдена читатель с идентификатором: " + request.getReadId());
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");

        Issue issue = new Issue(request.getBookId(), request.getReadId());
        issue.setNameBook(book.getName());
        issue.setNameRead(reader.getName());
        //issue.setEndTimestamp(dtf.format(LocalDateTime.now()));
        repository.getAll().add(issue);
        return issue ;
    }
    public List<Issue> getAll(){
        return repository.getAll();
    }

    public Issue deleteIssue(long id){
        Issue issue = getIssById(id);
        if(issue != null){
            repository.getAll().removeIf(it -> Objects.equals(it.getId(), id));
            return issue;
        }
        return null;
    }
    public Issue issue(IssueRequest request){
        Book book = services.getBookById(request.getBookId());
        if(book == null){
            throw new NoSuchElementException("Не найдена книга с идентификатором: " + request.getBookId());
        }
        Reader reader = readerRepository.getReaderById(request.getReadId());
        if(reader == null){
            throw new NoSuchElementException("Не найдена читатель с идентификатором: " + request.getReadId());
        }

        Issue issue = new Issue(request.getBookId(),request.getReadId());
        repository.save(issue);
        return issue;
    }
}
