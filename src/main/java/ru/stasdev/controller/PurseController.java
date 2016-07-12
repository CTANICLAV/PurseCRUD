package ru.stasdev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;
import ru.stasdev.domain.Purse;
import ru.stasdev.service.CurrencyService;
import ru.stasdev.service.PurseService;
import ru.stasdev.service.UserService;

@Controller
@RequestMapping("/")
public class PurseController {

    public static final String CHANGE_PURSE = "changePurse";
    public static final String ALL_PURSE = "allPurse";

    @Autowired
    private CurrencyService currencyService;

    @Autowired
    private PurseService purseService;

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String showPageAllPurses(ModelMap model) {
        model.addAttribute("purses", purseService.getAll());
        return ALL_PURSE;
    }

    @RequestMapping(value = "/add/purse", method = RequestMethod.GET)
    public String showPageAddPurse(ModelMap model) {
        model.addAttribute("inspection", "add");
        model.addAttribute("users", userService.getAll());
        model.addAttribute("currencies", currencyService.getAll());
        return CHANGE_PURSE;
    }

    @RequestMapping(value = "/add/purse", method = RequestMethod.POST)
    public RedirectView addPurse(@RequestParam String savePurseName, @RequestParam int savePurseCurrencyId, @RequestParam int savePurseOwnerId, @RequestParam int savePurseAmount) {
        purseService.insert(new Purse(0, savePurseName, savePurseCurrencyId, savePurseOwnerId, savePurseAmount));
        return new RedirectView("/PurseCRUD-1.0-SNAPSHOT");
    }

    @RequestMapping(value = "/edit/purse/{id}", method = RequestMethod.GET)
    public String showPageEditPurse(@PathVariable(value = "id") Long id, ModelMap model) {
        model.addAttribute("inspection", "edit");
        model.addAttribute("users", userService.getAll());
        model.addAttribute("currencies", currencyService.getAll());
        model.addAttribute("editPurse", purseService.getById(id));
        return CHANGE_PURSE;
    }

    @RequestMapping(value = "/edit/purse/{id}", method = RequestMethod.POST)
    public RedirectView editPurse(@PathVariable(value = "id") Long id, @RequestParam String savePurseName, @RequestParam int savePurseOwnerId, @RequestParam int savePurseCurrencyId, @RequestParam int savePurseAmount, ModelMap model) {
        purseService.update(new Purse(id, savePurseName, savePurseCurrencyId, savePurseOwnerId, savePurseAmount));
        return new RedirectView("/PurseCRUD-1.0-SNAPSHOT");
    }


    @RequestMapping(value = "/delete/purse/{id}", method = RequestMethod.GET)
    public RedirectView deletePurse(@PathVariable(value = "id") Long id) {
        purseService.deleteById(id);
        return new RedirectView("/PurseCRUD-1.0-SNAPSHOT");
    }

    private boolean validityChecking(String st) {
        try {
            Integer.parseInt(st);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}