package ru.gb.book_distribution.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gb.book_distribution.model.Role;
import ru.gb.book_distribution.services.StandartRoleService;

import java.util.List;

@Slf4j
@Controller
@RequestMapping(path = "/role")
@RequiredArgsConstructor
public class RoleController {
    @Autowired
    private final StandartRoleService service;

    @GetMapping
    public String getRoleAll(Model model){
        List<Role> roles = service.getRoleAll();
        model.addAttribute("items", roles);
        log.info("Список ролей" + roles);
        return "tableRoles";
    }

}
