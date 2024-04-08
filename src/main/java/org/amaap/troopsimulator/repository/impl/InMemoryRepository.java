package org.amaap.troopsimulator.repository.impl;

import org.amaap.troopsimulator.repository.TroopRepository;
import org.amaap.troopsimulator.repository.impl.database.InMemoryDatabase;

import java.util.List;

public class InMemoryRepository implements TroopRepository {

    private  final InMemoryDatabase inMemoryDatabase;
    public InMemoryRepository(InMemoryDatabase inMemoryDatabase){
       this.inMemoryDatabase=inMemoryDatabase;
    }

    @Override
    public void insert(int troopCount, String troopType) {
        inMemoryDatabase.insertIntoTroopTable(troopCount,troopType);
    }


    @Override
    public List<Object> getBarbarians() {
        return inMemoryDatabase.getTroopers();
    }

    @Override
    public List<Object> getArchers() {
        return  inMemoryDatabase.getTroopers();
    }
}
