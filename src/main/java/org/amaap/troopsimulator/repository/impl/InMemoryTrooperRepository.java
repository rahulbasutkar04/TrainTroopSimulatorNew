package org.amaap.troopsimulator.repository.impl;

import org.amaap.troopsimulator.repository.TroopRepository;
import org.amaap.troopsimulator.repository.impl.database.InMemoryDatabase;
import org.amaap.troopsimulator.service.exception.InvalidTroopTypeException;

import java.util.List;

public class InMemoryTrooperRepository implements TroopRepository {

    private final InMemoryDatabase inMemoryDatabase;

    public InMemoryTrooperRepository(InMemoryDatabase inMemoryDatabase) {
        this.inMemoryDatabase = inMemoryDatabase;
    }

    @Override
    public void insert(int troopCount, String troopType) throws InvalidTroopTypeException {
        inMemoryDatabase.insertIntoTroopTable(troopCount, troopType);
    }


    @Override
    public List<Object> getBarbarians() {
        return inMemoryDatabase.getTroopers();
    }

    @Override
    public List<Object> getArchers() {
        return inMemoryDatabase.getTroopers();
    }

    @Override
    public List<Object> getTroopers() {
        return inMemoryDatabase.getTroopers();
    }
}
