package ru.stasdev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.stasdev.dao.ConnectionFactory;
import ru.stasdev.dao.PurseDao;
import ru.stasdev.dao.PurseDaoJdbcImpl;
import ru.stasdev.domain.Purse;

@Controller
@RequestMapping("/")
public class HelloController {
    private static PurseDao purseDao = null;

    static{
        purseDao = new PurseDaoJdbcImpl(ConnectionFactory.getInstance());
    }

    @RequestMapping(method = RequestMethod.GET)
    public String allPurse(ModelMap model){
        model.addAttribute("purse",purseDao.getAll());
        return "allPurse";
    }

    @RequestMapping(value ="/addPurse", method = RequestMethod.GET)
    public String addPurse(ModelMap model){
        return "addPurse";
    }

    @RequestMapping(value ="/addPurse", method = RequestMethod.POST)
    public String purseInput(@RequestParam String addName,@RequestParam String addCurrency,
                             @RequestParam int addAmount, ModelMap model){
        purseDao.insert(new Purse(0,addName,addCurrency,addAmount));
        return allPurse(model);
    }

    @RequestMapping(value = "cancel",method = RequestMethod.GET)
    public String cancelAdd(ModelMap model){return allPurse(model);}

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editPurse(@PathVariable(value = "id") Long id, ModelMap model){
        model.addAttribute("purseId",purseDao.getById(id));
        return "editPurse";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String purseUpdate(@PathVariable(value = "id") Long id, @RequestParam String editName,
                              @RequestParam String editCurrency,@RequestParam int editAmount, ModelMap model){
        purseDao.update(new Purse(id, editName, editCurrency, editAmount));
        return allPurse(model);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deletePurse(@PathVariable(value = "id")Long id,ModelMap model){
        purseDao.deleteById(id);
        return allPurse(model);
    }
}
