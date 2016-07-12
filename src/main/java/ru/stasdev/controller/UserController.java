package ru.stasdev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;
import ru.stasdev.domain.User;
import ru.stasdev.service.UserService;

@Controller
public class UserController {
    public static final String ALL_USER = "allUser";
    private static final String CHANGE_USER = "changeUser";
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/all/user", method = RequestMethod.GET)
    public String showAllUsers(ModelMap model) {
        model.addAttribute("users", userService.getAll());
        return ALL_USER;
    }

    @RequestMapping(value = "/add/user", method = RequestMethod.GET)
    public String showPageAddUser(ModelMap model) {
        model.addAttribute("inspection", "add");
        return CHANGE_USER;
    }

    @RequestMapping(value = "/add/user", method = RequestMethod.POST)
    public RedirectView addUser(@RequestParam String saveUserName, @RequestParam String saveUserLastName) {
        userService.insert(new User(0, saveUserName, saveUserLastName));
        return new RedirectView("/PurseCRUD-1.0-SNAPSHOT/all/user");
    }

    @RequestMapping(value = "/delete/user/{id}", method = RequestMethod.GET)
    public RedirectView deletePurse(@PathVariable(value = "id") Long id) {
        userService.deleteById(id);
        return new RedirectView("/PurseCRUD-1.0-SNAPSHOT/all/user");
    }

    @RequestMapping(value = "/edit/user/{id}", method = RequestMethod.GET)
    public String showPageEditCurrency(@PathVariable(value = "id") Long id, ModelMap model) {
        model.addAttribute("inspection", "edit");
        model.addAttribute("editUser", userService.getById(id));
        return CHANGE_USER;
    }

    @RequestMapping(value = "/edit/user/{id}", method = RequestMethod.POST)
    public RedirectView currencyEdit(@PathVariable(value = "id") Long id, @RequestParam String saveUserName, @RequestParam String saveUserLastName) {
        userService.update(new User(id, saveUserName, saveUserLastName));
        return new RedirectView("/PurseCRUD-1.0-SNAPSHOT/all/currency");
    }
}
