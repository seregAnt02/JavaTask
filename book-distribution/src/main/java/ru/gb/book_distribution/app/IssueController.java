package ru.gb.book_distribution.app;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gb.book_distribution.model.Issue;
import ru.gb.book_distribution.repository.IssueRepository;

import java.util.List;

@Slf4j
@Controller
@RequestMapping(path = "/ui")
public class IssueController {
    @Autowired
    private final IssueRepository repository;


    public IssueController(IssueRepository repository) {
        this.repository = repository;
    }


    @GetMapping(path = "/issue")
    public String list(Model model){
        List<Issue> issues = this.repository.findAll();
        model.addAttribute("items", issues);
        log.info("Список читателей" + issues);
        return "tableReader";
    }
}
