package ru.usersHibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.usersHibernate.Service.UserService;
import ru.usersHibernate.model.User;

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

    @GetMapping("/new")
    public String createNewUserHtmlForm(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/index";
    }

    @GetMapping("/edit/{id}")
    public String goToEditPage(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getById(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:/index";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/index";
    }

}
