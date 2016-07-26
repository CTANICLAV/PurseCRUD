package ru.stasdev.domain;

public class Exchange {
    private long id;
    private long sourceCurrencyId;
    private String sourceCurrencyShortName;
    private long targetCurrencyId;
    private String targetCurrencyShortName;
    private double exchangeRate;

    public Exchange() {}

    public Exchange(long id, long sourceCurrencyId, long targetCurrencyId, double exchangeRate) {
        this.id = id;
        this.sourceCurrencyId = sourceCurrencyId;
        this.targetCurrencyId = targetCurrencyId;
        this.exchangeRate = exchangeRate;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSourceCurrencyId() {
        return sourceCurrencyId;
    }

    public void setSourceCurrencyId(long sourceCurrencyId) {
        this.sourceCurrencyId = sourceCurrencyId;
    }

    public String getSourceCurrencyShortName() {
        return sourceCurrencyShortName;
    }

    public void setSourceCurrencyShortName(String sourceCurrencyShortName) {
        this.sourceCurrencyShortName = sourceCurrencyShortName;
    }

    public long getTargetCurrencyId() {
        return targetCurrencyId;
    }

    public void setTargetCurrencyId(long targetCurrencyId) {
        this.targetCurrencyId = targetCurrencyId;
    }

    public String getTargetCurrencyShortName() {
        return targetCurrencyShortName;
    }

    public void setTargetCurrencyShortName(String targetCurrencyShortName) {
        this.targetCurrencyShortName = targetCurrencyShortName;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    @Override
    public String toString() {
        return "Exchange    {" +
                "id=" + id +
                ", sourceCurrencyId=" + sourceCurrencyId +
                ", sourceCurrencyShortName='" + sourceCurrencyShortName + '\'' +
                ", targetCurrencyId=" + targetCurrencyId +
                ", targetCurrencyShortName='" + targetCurrencyShortName + '\'' +
                ", exchangeRate=" + exchangeRate +
                '}';
    }

}
