package com.gb.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/issue")
public class IssueController {

    @GetMapping("/{id}")
    public IssueResponse getBookById(@PathVariable long id){
        IssueResponse issue = new IssueResponse();
        issue.setId(id);
        issue.setName("Issue #" + id);
        return issue;
    }
}
