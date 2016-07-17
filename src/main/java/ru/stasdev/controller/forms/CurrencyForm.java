package ru.stasdev.controller.forms;

import ru.stasdev.domain.Currency;

public class CurrencyForm {
    private String id;
    private String shortName;

    public CurrencyForm() {
    }

    public CurrencyForm(Currency currency) {
        this.id = Long.toString(currency.getId());
        this.shortName = currency.getName();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @Override
    public String toString() {
        return "CurrencyForm{"+
                "id="+id+'\''+
                ", shortName="+shortName+'}';
    }
}
