package ru.stasdev.domain;
import javax.persistence.*;
import java.util.List;

@Entity
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;
    @OneToMany(fetch= FetchType.LAZY, mappedBy="sourceCurrency")
    private List<Exchange> sourceCurrency;
    @OneToMany(fetch= FetchType.LAZY, mappedBy="targetCurrency")
    private List<Exchange> targetCurrency;
    @OneToMany(fetch= FetchType.LAZY, mappedBy="currency")
    private List<Purse> purses;


    public Currency() {

    }

    public Currency(String name) {
        this.name = name;
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

    public List<Exchange> getSourceCurrency() {
        return sourceCurrency;
    }

    public void setSourceCurrency(List<Exchange> sourceCurrency) {
        this.sourceCurrency = sourceCurrency;
    }

    public List<Exchange> getTargetCurrency() {
        return targetCurrency;
    }

    public void setTargetCurrency(List<Exchange> targetCurrency) {
        this.targetCurrency = targetCurrency;
    }

    public List<Purse> getPurses() {
        return purses;
    }

    public void setPurses(List<Purse> purses) {
        this.purses = purses;
    }

}
