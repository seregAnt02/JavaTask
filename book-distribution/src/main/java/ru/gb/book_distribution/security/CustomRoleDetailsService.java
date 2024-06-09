package ru.gb.book_distribution.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.gb.book_distribution.model.Role;
import ru.gb.book_distribution.repository.RoleRepository;

import java.util.List;

@Component
public class CustomRoleDetailsService {
    private static long sequence = 1L;
    private final RoleRepository repository;

    public CustomRoleDetailsService(RoleRepository repository) {
        this.repository = repository;
        addRole("admin");
        addRole("user");
        addRole("auth");
    }

    private void addRole(String nameRole){
        Role role = new Role();
        role.setId(sequence++);
        role.setName(nameRole);
        repository.save(role);
    }

}
