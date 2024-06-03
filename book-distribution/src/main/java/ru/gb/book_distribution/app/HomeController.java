package ru.gb.book_distribution.app;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.gb.book_distribution.model.Book;
import ru.gb.book_distribution.services.StandardBookService;

import java.util.List;

@Slf4j
@Controller
@RequestMapping(path = "/ui")
public class HomeController {

    @Autowired
    private final StandardBookService services;

    public HomeController(StandardBookService services) {
        this.services = services;
    }

    @GetMapping(path = "/books")
    public String list(Model model){
        List<Book> books = this.services.getAllBooks();
        model.addAttribute("items", books);
        log.info("Список книг" + books);
        return "list";
    }
    @GetMapping(path = "/home")
    public String home(@RequestParam(required = false) String name, Model model){
        if(name != null){
            model.addAttribute("name", name);
        }else {
            model.addAttribute("name", "World");
        }
        log.info("Стартует ручка home");
        return "home";
    }
}
