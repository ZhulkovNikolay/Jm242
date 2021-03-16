package ru.usersHibernate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsersController {

    @GetMapping(value = {"/", "/index"})
    public String index() {
        return "index";
    }

}
