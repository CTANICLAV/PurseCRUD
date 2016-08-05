package ru.stasdev.domain;

import javax.persistence.*;
import java.math.BigDecimal;
@Entity
public class Purse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "currencyId")
    private Currency currency;
    @ManyToOne
    @JoinColumn(name = "ownerId")
    private User owner;
    @Column(name = "amount")
    private BigDecimal amount;

    public Purse() {

    }

    public Purse(String name, Currency currency, User owner, BigDecimal amount) {
        this.name = name;
        this.currency = currency;
        this.owner = owner;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

}