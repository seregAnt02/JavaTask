package ru.gb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/student")
public class StudentController {

    private final StudentRepository repository;

    @Autowired
    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    @GetMapping(path = "/{id}")
    public Student getStudent(@PathVariable Long id){
        return repository.getById(id);
    }

    @GetMapping(path = "/all")
    public List<Student> getAll(){
        return repository.getAll();
    }

    @GetMapping
    public Student getStudentByName(@RequestParam String name){
        return repository.getStudentByName(name);
    }

    @PostMapping(path = "/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student){
        return repository.updateStudent(id, student);
    }
    @DeleteMapping(path = "/{id}")
    public void deleteStudent(@PathVariable Long id){
        repository.deleteStudent(id);
    }

   }
