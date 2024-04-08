package org.amaap.troopsimulator.repository.impl.database.implementation;

import org.amaap.troopsimulator.domain.model.Archer;
import org.amaap.troopsimulator.domain.model.Barbarian;
import org.amaap.troopsimulator.repository.impl.database.InMemoryDatabase;

import java.util.ArrayList;
import java.util.List;

public class FakeDatabase implements InMemoryDatabase {

    private List<Object> troopList = new ArrayList<>();

    @Override
    public void insertIntoTroopTable(int troopCount, String troopType) {
        if ("Barbarian".equals(troopType)) {
            for (int i = 0; i < troopCount; i++) {
                troopList.add(new Barbarian());
            }
        } else if ("Archer".equals(troopType)) {
            for (int i = 0; i < troopCount; i++) {
                troopList.add(new Archer());
            }
        } else {
            throw new IllegalArgumentException("Invalid troop type: " + troopType);
        }
    }

    @Override
    public List<Object> getTroopers() {
        return troopList;
    }
}
