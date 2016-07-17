package ru.stasdev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import ru.stasdev.controller.forms.UserForm;
import ru.stasdev.controller.validator.UserFromValidator;
import ru.stasdev.domain.User;
import ru.stasdev.service.UserService;

@Controller
public class UserController {
    public static final String ALL_USER = "allUser";
    public static final String SAVE_USER = "saveUser";
    public static final String ERROR_PAGE = "errorPage";
    @Autowired
    UserFromValidator userFromValidator;
    @Autowired
    private UserService userService;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(userFromValidator);
    }

    @RequestMapping(value = "/all/user", method = RequestMethod.GET)
    public String showAllUsers(ModelMap model) {
        model.addAttribute("users", userService.getAll());
        return ALL_USER;
    }

    @RequestMapping(value = "/save/user", method = RequestMethod.GET)
    public String showPageAddUser(ModelMap model) {
        model.addAttribute("userForm", new UserForm());
        return SAVE_USER;
    }

    @RequestMapping(value = "/save/user/{id}", method = RequestMethod.GET)
    public String showPageEditUser(@PathVariable(value = "id") Long id, ModelMap model) {
        User user = userService.getById(id);
        if (user == null) {
            return ERROR_PAGE;
        }
        model.addAttribute("userForm", new UserForm(user));
        return SAVE_USER;
    }

    @RequestMapping(value = "/save/user", method = RequestMethod.POST)
    public String saveUser(@Validated UserForm userForm, BindingResult bindingResult, ModelMap model) {
        if (bindingResult.hasErrors()) {
            return SAVE_USER;
        }
        if ("".equals(userForm.getId())){
            userService.insert(new User(0, userForm.getFirstName(), userForm.getLastName()));
        }else{
            userService.update(new User(Integer.parseInt(userForm.getId()), userForm.getFirstName(), userForm.getLastName()));
        }
        return showAllUsers(model);
    }

    @RequestMapping(value = "/delete/user/{id}", method = RequestMethod.GET)
    public RedirectView deleteUser(@PathVariable(value = "id") Long id) {
        userService.deleteById(id);
        return new RedirectView("/PurseCRUD-1.0-SNAPSHOT/all/user");
    }
}