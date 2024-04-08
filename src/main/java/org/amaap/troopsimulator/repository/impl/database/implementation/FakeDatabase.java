package org.amaap.troopsimulator.repository.impl.database.implementation;

import org.amaap.troopsimulator.domain.model.Archer;
import org.amaap.troopsimulator.domain.model.Barbarian;
import org.amaap.troopsimulator.repository.impl.database.InMemoryDatabase;
import org.amaap.troopsimulator.service.exception.InvalidTroopTypeException;

import java.util.ArrayList;
import java.util.List;

public class FakeDatabase implements InMemoryDatabase {

    private List<Object> troopList = new ArrayList<>();

    @Override
    public void insertIntoTroopTable(int troopCount, String troopType) throws InvalidTroopTypeException {
        if ("Barbarian".equals(troopType)) {
            for (int i = 0; i < troopCount; i++) {
                troopList.add(new Barbarian());
            }
        } else if ("Archer".equals(troopType)) {
            for (int i = 0; i < troopCount; i++) {
                troopList.add(new Archer());
            }
        } else {
            throw new InvalidTroopTypeException("Invalid troop type: " + troopType);
        }
    }

    @Override
    public List<Object> getTroopers() {
        return troopList;
    }
}