package ru.gb;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class StudentRepository {
    private final List<Student> repository;

    public StudentRepository() {
        this.repository = new ArrayList<>();
        repository.add(new Student( "User1", "01A"));
        repository.add(new Student( "User2", "02B"));
        repository.add(new Student( "User3", "01A"));
        repository.add(new Student( "User4", "02B"));
        repository.add(new Student( "User5", "01A"));
    }

    public Student getById(Long id){
        return repository.stream().filter(it -> it.getId() == id).findFirst().orElse(null);
    }

    public List<Student> getAll(){
        return List.copyOf(repository);
    }

    public  Student getStudentByName(String name){
        return repository.stream().filter(it -> Objects.equals(it.getName(), name)).findFirst().orElse(null);
    }

    public List<Student> getStudentByGroup(String name){
        return repository.stream().filter(it -> Objects.equals(it.getGroupName(), name)).toList();
    }

    public Student updateStudent(Long id, Student student){
        Student existStudent = getById(id);
        existStudent.setName(student.getName());
        return existStudent;
    }

    public void deleteStudent(Long id){
        Student student = getById(id);
        if(student != null){
            repository.removeIf(it -> it.getId().equals(id));
        }
    }

}
