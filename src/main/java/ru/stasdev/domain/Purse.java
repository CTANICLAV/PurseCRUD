package ru.stasdev.domain;

public class Purse {
    private long id;
    private String name;
    private String currency;
    private int amount;

    public Purse(long id, String name, String currency,int amount){
        this.id = id;
        this.name = name;
        this.currency = currency;
        this.amount = amount;
    }

    public String getName(){return name;}

    public void setName(String name){this.name = name;}

    public long getId(){return id;}

    public void setId(long id){this.id = id;}

    public String getCurrency(){return currency;}

    public void setCurrency(String currency){this.currency = currency;}

    public int getAmount(){return amount;}

    public void setAmount(int amount){this.amount = amount;}

    @Override
    public String toString(){
        return "Purse{ "+
                "id "+getId()+
                "name "+getName()+
                "currency "+getCurrency()+
                "amount "+getAmount();
    }

}
