package ru.gb.book_distribution.app;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gb.book_distribution.model.Issue;
import ru.gb.book_distribution.model.IssueRequest;
import ru.gb.book_distribution.model.Reader;
import ru.gb.book_distribution.services.IssServices;

import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@Controller
@RequestMapping(path = "/ui")
public class IssueController {
    @Autowired
    private final IssServices services;


    public IssueController(IssServices services) {
        this.services = services;
    }


    @GetMapping(path = "/issue")
    public String list(Model model){
        List<Issue> issues = this.services.getAll();
        model.addAttribute("items", issues);
        log.info("Список читателей" + issues);
        return "tableReader";
    }
}
