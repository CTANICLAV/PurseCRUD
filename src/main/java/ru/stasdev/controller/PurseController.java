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


@Controller
@RequestMapping("/")
public class PurseController {

    public static final String CHANGE_PURSE = "changePurse";
    public static final String ALL_PURSE = "allPurse";

    @Autowired
    private CurrencyService currencyService;

    @Autowired
    private PurseService purseService;

    public void setCurrencyService(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    public void setPurseService(PurseService purseService){
        this.purseService = purseService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showPageAllPurses(ModelMap model) {
        model.addAttribute("purses", purseService.getAll());
        return ALL_PURSE;
    }

    @RequestMapping(value = "/add/purse", method = RequestMethod.GET)
    public String showPageAddPurse(ModelMap model) {
        model.addAttribute("checkEditOfAddPurse", "addPurse");
        model.addAttribute("allCurrencyName", currencyService.getAll());
        return CHANGE_PURSE;
    }

    @RequestMapping(value = "/add/purse", method = RequestMethod.POST)
    public RedirectView addPurse(@RequestParam String addPurseName, @RequestParam int addPurseCurrency, @RequestParam int addPurseAmount) {
        purseService.insert(new Purse(0, addPurseName, addPurseCurrency, addPurseAmount));
        return new RedirectView("/PurseCRUD-1.0-SNAPSHOT");
    }

    @RequestMapping(value = "/edit/purse/{id}", method = RequestMethod.GET)
    public String showPageEditPurse(@PathVariable(value = "id") Long id, ModelMap model) {
        model.addAttribute("checkEditOfAddPurse", "editPurse");
        model.addAttribute("allCurrencyName", currencyService.getAll());
        model.addAttribute("editPurse", purseService.getById(id));
        return CHANGE_PURSE;
    }

    @RequestMapping(value = "/edit/purse/{id}", method = RequestMethod.POST)
    public RedirectView editPurse(@PathVariable(value = "id") Long id, @RequestParam String editPurseName, @RequestParam int editPurseCurrency, @RequestParam int editPurseAmount) {
        purseService.update(new Purse(id, editPurseName, editPurseCurrency, editPurseAmount));
        return new RedirectView("/PurseCRUD-1.0-SNAPSHOT");
    }

    @RequestMapping(value = "/delete/purse/{id}", method = RequestMethod.GET)
    public RedirectView deletePurse(@PathVariable(value = "id") Long id, ModelMap model) {
        purseService.deleteById(id);
        return new RedirectView("/PurseCRUD-1.0-SNAPSHOT");
    }
}