package ru.gb;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    private Long id;

    @Column(name = "name")
    private String name;
// геттеры и сеттеры
}

