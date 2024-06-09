package ru.gb.book_distribution.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.book_distribution.model.Role;
import ru.gb.book_distribution.model.User;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
