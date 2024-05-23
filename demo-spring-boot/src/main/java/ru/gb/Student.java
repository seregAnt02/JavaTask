package ru.gb;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Data;

@Data
public class Student {

    private static Long idCounter = 1L;

    private final Long id;
    private String name;
    private String groupName;



    @JsonCreator
    public Student(String name, String groupName) {
        this.id = idCounter++;
        this.name = name;
        this.groupName = groupName;
    }
}
