package ru.gb.book_distribution.app;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gb.book_distribution.model.Book;
import ru.gb.book_distribution.model.Reader;
import ru.gb.book_distribution.services.BookServices;
import ru.gb.book_distribution.services.ReaderServices;

import java.util.List;

@Slf4j
@Controller
@RequestMapping(path = "/ui")
public class ReaderController {
    @Autowired
    private final ReaderServices services;

    public ReaderController(ReaderServices services) {
        this.services = services;
    }

    @GetMapping(path = "/reader")
    public String list(Model model){
        List<Reader> readers = this.services.getAllByBook();
        model.addAttribute("items", readers);
        log.info("Список читателей" + readers);
        return "list";
    }
}
