package ru.gb.book_distribution.app;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.book_distribution.model.Issue;
import ru.gb.book_distribution.services.IssServices;

@Slf4j
@RestController
@RequestMapping("/issue")
public class IssueController {

    @Autowired
    IssServices services;
    @PostMapping
    public Issue issueBook(@RequestBody IssueRequest request){
        log.info("Получен запрос на выдачу: readId = {}, bookId = {}", request.getReadId(), request.getBookId());

        return services.issue(request);
    }
}
