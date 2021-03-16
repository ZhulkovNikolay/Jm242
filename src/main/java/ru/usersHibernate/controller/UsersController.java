package ru.usersHibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.usersHibernate.Service.UserService;
import ru.usersHibernate.Service.UserServiceImp;
import ru.usersHibernate.model.User;

import java.util.List;

@Controller
public class UsersController {

    private UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = {"/", "/index"})
    public String index(Model model) {
        model.addAttribute("users", userService.allUsers());
        return "index";
    }

    @GetMapping("/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getById(id));
        return "edit";
    }
}
