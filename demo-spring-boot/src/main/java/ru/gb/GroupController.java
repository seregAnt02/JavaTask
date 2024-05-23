package ru.gb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/group")
public class GroupController {

    private final StudentRepository repository;

    @Autowired
    public GroupController(StudentRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Student> getStudentByGroup(@RequestParam String groupName){
        return repository.getStudentByGroup(groupName);
    }

}
