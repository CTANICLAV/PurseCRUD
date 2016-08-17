package ru.stasdev.dao;


import org.springframework.stereotype.Repository;
import ru.stasdev.domain.Purse;

import javax.annotation.PostConstruct;

@Repository
public class PurseDAOImpl extends GenericDAOImpl<Purse> implements PurseDAO {

    @PostConstruct
    public void init() {
        super.setType(Purse.class);
    }
}
