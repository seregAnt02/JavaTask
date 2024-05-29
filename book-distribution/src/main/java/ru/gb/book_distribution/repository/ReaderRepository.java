package ru.gb.book_distribution.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import ru.gb.book_distribution.model.Book;
import ru.gb.book_distribution.model.Reader;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class ReaderRepository {
    private final List<Reader> readers;

    public ReaderRepository() {
        this.readers = new ArrayList<>();
    }

    @PostConstruct
    public void generateDate(){
        readers.addAll(List.of(
                new Reader("Name1"),
                new Reader("Name2"),
                new Reader("Name3")
        ));
    }

    public Reader getReaderById(long id){
        return readers.stream()
                .filter(it -> Objects.equals(it.getId(), id))
                .findFirst()
                .orElse(null);
    }
    public  List<Reader> getAll(){
        return readers;
    }
}
