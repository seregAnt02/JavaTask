package ru.gb.book_distribution.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gb.book_distribution.model.Book;
import ru.gb.book_distribution.model.Reader;
import ru.gb.book_distribution.repository.ReaderRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReaderServices {

    private final ReaderRepository repository;
    public List<Reader> getAllByBook(){
        return repository.getAll();
    }
}
