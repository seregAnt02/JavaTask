package ru.gb.book_distribution.app;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.book_distribution.model.Book;
import ru.gb.book_distribution.model.Issue;
import ru.gb.book_distribution.model.IssueRequest;
import ru.gb.book_distribution.services.IssServices;

import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@RestController
@RequestMapping("/issue")
public class IssueController {

    @Autowired
    IssServices services;

    @GetMapping(path = "/{id}")
    public ResponseEntity<Issue> getIssById(@PathVariable long id){
        Issue issue = services.getIssById(id);
        if(issue != null)
            log.info("Пользователь найден: " + issue);
        log.info("Внимание! Пользователь не найден: " + issue);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(issue);
    }


    @PostMapping(path = "/create")
    public ResponseEntity<Issue> crateIssue(@RequestBody IssueRequest issueRequest){
        Issue issue = null;
        try{
            issue = this.services.createIssue(new Issue(issueRequest.getBookId(), issueRequest.getReadId()));
            if(issue != null)
                log.info("Создание читателя: " + issue);
        }catch (NoSuchElementException ex){
            log.info("Внимание! Создание читателя не удалось");
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(issue);
    }

    @GetMapping( path = "/all")
    public List<Issue> getAll(){
        return services.getAll();
    }

    @DeleteMapping(path = "/{id}")
    public void deleteIssue(@PathVariable long id){
        Issue issue = null;
        try{
            issue = this.services.deleteIssue(id);
            if(issue != null)
                log.info("Удаление читателя: " + issue);
        }catch (NoSuchElementException ex){
            log.info("Внимание! Удалить читателя не удалось");
            ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Issue> issueBook(@RequestBody IssueRequest request){
        log.info("Получен запрос на выдачу: readId = {}, bookId = {}", request.getReadId(), request.getBookId());

        final Issue issue;
        try {
            issue = new Issue(request.getBookId(), request.getReadId());
        }catch (NoSuchElementException ex) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(issue);
    }
}
