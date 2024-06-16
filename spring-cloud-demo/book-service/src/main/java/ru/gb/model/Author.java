package ru.gb.model;

import lombok.Data;

import java.util.UUID;

@Data
public class Author {
    private UUID id;
    private String name;
    private String firstName;
    private String lastName;
}
