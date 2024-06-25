package com.gb.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reader")
public class ReaderController {

    @GetMapping("/{id}")
    public ReaderResponse getBookById(@PathVariable long id){
        ReaderResponse reader = new ReaderResponse();
        reader.setId(id);
        reader.setName("Reader #" + id);
        return reader;
    }
}
