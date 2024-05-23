package ru.gb;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentRepository {
    private final List<Student> students;

    public StudentRepository() {
        this.students = new ArrayList<>();
        students.add(new Student( "User1", "01A"));
        students.add(new Student( "User2", "02B"));
        students.add(new Student( "User3", "01A"));
        students.add(new Student( "User4", "02B"));
        students.add(new Student( "User5", "01A"));
    }

    public Student getById(Long id){
        return students.stream().filter(it -> it.getId() == id).findFirst().orElse(null);
    }

    public List<Student> getAll(){
        return List.copyOf(students);
    }

}
