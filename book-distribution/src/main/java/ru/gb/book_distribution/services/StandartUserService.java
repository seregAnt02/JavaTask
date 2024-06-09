package ru.gb.book_distribution.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.book_distribution.model.User;
import ru.gb.book_distribution.repository.UserRepository;

import java.util.List;

@Slf4j
@Service
public class StandartUserService {

    @Autowired
    private final UserRepository repository;

    public StandartUserService(UserRepository userRepository) {
        this.repository = userRepository;
    }


    public List<User> getUserAll(){
        return repository.findAll();
    }
}
