package ru.stasdev.controller.forms;


import ru.stasdev.domain.Exchange;

public class ExchangeForm {
    private String id;
    private String sourceCurrencyId;
    private String targetCurrencyId;
    private String exchangeRate;

    public ExchangeForm() {

    }

    public ExchangeForm(Exchange exchange) {
        this.id = Long.toString(exchange.getId());
        this.sourceCurrencyId = Long.toString(exchange.getSourceCurrency().getId());
        this.targetCurrencyId = Long.toString(exchange.getTargetCurrency().getId());
        this.exchangeRate = Double.toString(exchange.getExchangeRate());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSourceCurrencyId() {
        return sourceCurrencyId;
    }

    public void setSourceCurrencyId(String sourceCurrencyId) {
        this.sourceCurrencyId = sourceCurrencyId;
    }

    public String getTargetCurrencyId() {
        return targetCurrencyId;
    }

    public void setTargetCurrencyId(String targetCurrencyId) {
        this.targetCurrencyId = targetCurrencyId;
    }

    public String getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(String exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    @Override
    public String toString() {
        return "ExchangeForm{" +
                "id='"+id+'\'' +
                ", sourceCurrencyId='" + sourceCurrencyId + '\'' +
                ", targetCurrencyId='" + targetCurrencyId + '\''+
                ", exchangeRate='" + exchangeRate + '\'' +
                '}';
    }
}
