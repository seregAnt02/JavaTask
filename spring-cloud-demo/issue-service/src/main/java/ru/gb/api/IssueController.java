package ru.gb.api;

import com.github.javafaker.Faker;
import ru.gb.BookProvider;
import ru.gb.model.Issue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZoneId;
import java.util.*;

@RestController
@RequestMapping("/api")
public class IssueController {
    private Faker faker;
    private final List<Issue> issues;

    public IssueController(BookProvider provider) {
        this.faker = new Faker();

        this.issues = new ArrayList<>();

        for (int i = 0; i < 15; i++){
            Issue issue = new Issue();
            issue.setId(UUID.randomUUID());

            Date between = faker.date().between(startOfYear(), endOfYear());
            issue.setIssuedAt(between.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            issue.setBookId(provider.getRandomBookId());
            issue.setReaderId(UUID.randomUUID());
            issues.add(issue);
        }
        List.copyOf(issues);
    }

    @GetMapping("/issue")
    public List<Issue> all(){
        return issues;
    }

    private Date startOfYear(){
        Calendar instance = Calendar.getInstance();
        instance.set(Calendar.YEAR, 2024);
        instance.set(Calendar.MONTH, 1);
        instance.set(Calendar.DAY_OF_MONTH, 1);
        return instance.getTime();
    }

    private Date endOfYear(){
        Calendar instance = Calendar.getInstance();
        instance.set(Calendar.YEAR, 2024);
        instance.set(Calendar.MONTH, Calendar.DECEMBER);
        instance.set(Calendar.DAY_OF_MONTH, 31);
        return instance.getTime();
    }

}
