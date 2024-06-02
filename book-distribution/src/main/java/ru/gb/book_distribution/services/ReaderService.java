package ru.gb.book_distribution.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.book_distribution.model.Reader;
import ru.gb.book_distribution.repository.ReaderRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReaderService {

    private final ReaderRepository repository;
    public List<Reader> getAllByBook(){
        return repository.getAll();
    }
}
