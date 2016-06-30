package ru.stasdev.controller;

        import org.springframework.stereotype.Controller;
        import org.springframework.ui.ModelMap;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestMethod;
        import org.springframework.web.bind.annotation.RequestParam;
        import org.springframework.web.servlet.view.RedirectView;
        import ru.stasdev.domain.Currency;
        import ru.stasdev.service.CurrencyService;
        import ru.stasdev.service.CurrencyServiceJdbcImpl;

@Controller
@RequestMapping("/")
public class CurrencyController {

    @RequestMapping(value = "all/currency", method = RequestMethod.GET)
    public String ShowPageAllCurrency(ModelMap model) {
        CurrencyService currencyService = new CurrencyServiceJdbcImpl();
        model.addAttribute("currency", currencyService.getAll());
        return "allCurrency";
    }

    @RequestMapping(value = "/add/currency", method = RequestMethod.GET)
    public String ShowPageAddCurrency(ModelMap model) {
        CurrencyService currencyService = new CurrencyServiceJdbcImpl();
        model.addAttribute("checkEditOfAddCurrency", "addCurrency");
        model.addAttribute("currency", currencyService.getAll());
        return "changeCurrency";
    }

    @RequestMapping(value = "/add/currency", method = RequestMethod.POST)
    public RedirectView addCurrency(@RequestParam String addCurrencyName, ModelMap model) {
        CurrencyService currencyService = new CurrencyServiceJdbcImpl();
        currencyService.insert(new Currency(0, addCurrencyName));
        return new RedirectView("/all/currency");
    }

    @RequestMapping(value = "/edit/currency/{id}", method = RequestMethod.GET)
    public String ShowPageEditCurrency(@PathVariable(value = "id") Long id, ModelMap model) {
        model.addAttribute("checkEditOfAddCurrency", "editCurrency");
        CurrencyService currencyService = new CurrencyServiceJdbcImpl();
        model.addAttribute("editCurrency", currencyService.getById(id));
        return "changeCurrency";
    }

    @RequestMapping(value = "/edit/currency/{id}", method = RequestMethod.POST)
    public RedirectView currencyEdit(@PathVariable(value = "id") Long id, @RequestParam String editCurrencyName, ModelMap model) {
        CurrencyService currencyService = new CurrencyServiceJdbcImpl();
        currencyService.update(new Currency(id, editCurrencyName));
        return new RedirectView("/all/currency");
    }

    @RequestMapping(value = "/delete/currency/{id}", method = RequestMethod.GET)
    public RedirectView deleteCurrency(@PathVariable(value = "id") Long id, ModelMap model) {
        CurrencyService currencyService = new CurrencyServiceJdbcImpl();
        currencyService.deleteById(id);
        return new RedirectView("/all/currency");
    }

}


