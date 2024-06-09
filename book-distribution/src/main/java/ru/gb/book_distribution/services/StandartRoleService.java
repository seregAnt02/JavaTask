package ru.gb.book_distribution.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.gb.book_distribution.model.Role;
import ru.gb.book_distribution.repository.RoleRepository;

import java.util.List;

@Slf4j
@Service
public class StandartRoleService {

    private final RoleRepository repository;

    public StandartRoleService(RoleRepository repository) {
        this.repository = repository;
    }

    public List<Role> getRoleAll(){
        return repository.findAll();
    }
}
