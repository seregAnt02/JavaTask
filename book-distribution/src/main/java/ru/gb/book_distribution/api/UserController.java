package ru.gb.book_distribution.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.book_distribution.model.User;
import ru.gb.book_distribution.services.StandartUserService;

import java.util.List;

@Slf4j
@Controller
@RequestMapping(path = "/user")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private final StandartUserService service;

    @GetMapping(path= "/all")
    public String getUserAll(Model model){
        List<User> users = service.getUserAll();
        model.addAttribute("items", users);
        log.info("Список читателей" + users);
        return "tableUsers";
    }
}
