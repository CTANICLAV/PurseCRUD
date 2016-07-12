package ru.stasdev.domain;

public class Purse {
    private long id;
    private int currencyId;
    private String name;
    private String currencyShortName;
    private int amount;
    private int ownerId;

    public Purse(long id, String name, int currencyId, int ownerId, int amount){
            this.id = id;
        this.name = name;
        this.currencyId = currencyId;
        this.amount = amount;
        this.ownerId = ownerId;
    }

    public String getName(){return name;}

    public void setName(String name){this.name = name;}

    public long getId(){return id;}

    public void setId(long id){this.id = id;}

    public int getCurrencyId(){return currencyId;}

    public void setIdCurrency(int currencyId){this.currencyId = currencyId;}

    public int getAmount(){return amount;}

    public void setAmount(int amount){this.amount = amount;}

    public void setCurrencyShortName(String currencyShortName){
        this.currencyShortName = currencyShortName;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public String getCurrencyShortName(){
        return currencyShortName;
    }

    @Override
    public String toString(){
        return "Purse{ "+
                "id "+id+
                "name "+name+
                "currencyId "+currencyId+
                "currencyShortName='"+currencyShortName+
                "ownerId='"+ownerId+
                "amount "+amount+'}';
    }

}
