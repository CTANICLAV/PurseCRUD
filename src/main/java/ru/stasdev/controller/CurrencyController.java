package ru.stasdev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
        import org.springframework.ui.ModelMap;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestMethod;
        import org.springframework.web.bind.annotation.RequestParam;
        import org.springframework.web.servlet.view.RedirectView;
        import ru.stasdev.domain.Currency;
        import ru.stasdev.service.CurrencyService;

@Controller
public class CurrencyController {

    public static final String CHANGE_CURRENCY = "changeCurrency";
    public static final String ALL_CURRENCY = "allCurrency";

    @Autowired
    private CurrencyService currencyService;

    @RequestMapping(value = "/all/currency", method = RequestMethod.GET)
    public String showPageAllCurrency(ModelMap model) {
        model.addAttribute("currencies", currencyService.getAll());
        return ALL_CURRENCY;
    }

    @RequestMapping(value = "/add/currency", method = RequestMethod.GET)
    public String showPageAddCurrency(ModelMap model) {
        model.addAttribute("inspection", "add");
        model.addAttribute("currencies", currencyService.getAll());
        return CHANGE_CURRENCY;
    }

    @RequestMapping(value = "/add/currency", method = RequestMethod.POST)
    public RedirectView addCurrency(@RequestParam String saveCurrencyName) {
        currencyService.insert(new Currency(0, saveCurrencyName));
        return new RedirectView("/PurseCRUD-1.0-SNAPSHOT/all/currency");
    }

    @RequestMapping(value = "/edit/currency/{id}", method = RequestMethod.GET)
    public String showPageEditCurrency(@PathVariable(value = "id") Long id, ModelMap model) {
        model.addAttribute("inspection", "edit");
        model.addAttribute("editCurrency", currencyService.getById(id));
        return CHANGE_CURRENCY;
    }

    @RequestMapping(value = "/edit/currency/{id}", method = RequestMethod.POST)
    public RedirectView currencyEdit(@PathVariable(value = "id") Long id, @RequestParam String saveCurrencyName) {
        currencyService.update(new Currency(id, saveCurrencyName));
        return new RedirectView("/PurseCRUD-1.0-SNAPSHOT/all/currency");
    }

    @RequestMapping(value = "/delete/currency/{id}", method = RequestMethod.GET)
    public RedirectView deleteCurrency(@PathVariable(value = "id") Long id) {
        currencyService.deleteById(id);
        return new RedirectView("/PurseCRUD-1.0-SNAPSHOT/all/currency");
    }

}



