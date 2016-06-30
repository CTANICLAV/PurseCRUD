package ru.stasdev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;
import ru.stasdev.domain.Purse;
import ru.stasdev.service.CurrencyService;
import ru.stasdev.service.CurrencyServiceJdbcImpl;
import ru.stasdev.service.PurseService;
import ru.stasdev.service.PurseServiceJdbcImpl;


@Controller
@RequestMapping("/")
public class PurseController {

    @RequestMapping(method = RequestMethod.GET)
    public String allPurses(ModelMap model) {
        PurseService purseService = new PurseServiceJdbcImpl();
        model.addAttribute("purse", purseService.getAll());
        return "allPurse";
    }

    @RequestMapping(value = "/add/purse", method = RequestMethod.GET)
    public String addPurse(ModelMap model) {
        CurrencyService currencyService = new CurrencyServiceJdbcImpl();
        model.addAttribute("checkEditOfAddPurse", "addPurse");
        model.addAttribute("allCurrencyName", currencyService.getAll());
        return "changePurse";
    }

    @RequestMapping(value = "/add/purse", method = RequestMethod.POST)
    public RedirectView purseInput(@RequestParam String addPurseName, @RequestParam String addPurseCurrency, @RequestParam int addPurseAmount, ModelMap model) {
        PurseService purseService = new PurseServiceJdbcImpl();
        purseService.insert(new Purse(0, addPurseName, addPurseCurrency, addPurseAmount));
        return new RedirectView("/");
    }

    @RequestMapping(value = "/edit/purse/{id}", method = RequestMethod.GET)
    public String editPurse(@PathVariable(value = "id") Long id, ModelMap model) {
        model.addAttribute("checkEditOfAddPurse", "editPurse");
        CurrencyService currencyService = new CurrencyServiceJdbcImpl();
        model.addAttribute("allCurrencyName", currencyService.getAll());
        PurseService purseService = new PurseServiceJdbcImpl();
        model.addAttribute("editPurse", purseService.getById(id));
        return "changePurse";
    }

    @RequestMapping(value = "/edit/purse/{id}", method = RequestMethod.POST)
    public RedirectView purseUpdate(@PathVariable(value = "id") Long id, @RequestParam String editPurseName, @RequestParam String editPurseCurrency, @RequestParam int editPurseAmount, ModelMap model) {
        PurseService purseService = new PurseServiceJdbcImpl();
        purseService.update(new Purse(id, editPurseName, editPurseCurrency, editPurseAmount));
        return new RedirectView("/");
    }

    @RequestMapping(value = "/delete/purse/{id}", method = RequestMethod.GET)
    public RedirectView deletePurse(@PathVariable(value = "id") Long id, ModelMap model) {
        PurseService purseService = new PurseServiceJdbcImpl();
        purseService.deleteById(id);
        return new RedirectView("/");
    }
}