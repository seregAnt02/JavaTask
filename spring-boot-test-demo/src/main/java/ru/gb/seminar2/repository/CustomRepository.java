package ru.gb.seminar2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.seminar2.model.Customer;

@Repository
public interface CustomRepository extends JpaRepository<Customer, Long> {
}
