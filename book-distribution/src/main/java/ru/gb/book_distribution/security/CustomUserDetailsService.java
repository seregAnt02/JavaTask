package ru.gb.book_distribution.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.gb.book_distribution.model.User;
import ru.gb.book_distribution.repository.UserRepository;

import java.util.List;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    private static long sequence = 1L;
    private final UserRepository repository;

    public CustomUserDetailsService(UserRepository repository) {
        this.repository = repository;
        addUser("admin", "pass", "admin");
        addUser("user", "pass", "user");
        addUser("auth", "pass", "auth");
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), List.of(
                new SimpleGrantedAuthority("admin"),
                new SimpleGrantedAuthority("user")
        ));
    }

    public void addUser(String login, String password, String role){
        User user = new User();
        user.setId(sequence++);
        user.setLogin(login);
        //user.setRole(role);
        user.setPassword(password);
        repository.save(user);
        System.out.println("findByLogin " + repository.findByLogin(login));
    }

}
