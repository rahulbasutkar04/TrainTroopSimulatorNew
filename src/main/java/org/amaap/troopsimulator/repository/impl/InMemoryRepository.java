package org.amaap.troopsimulator.repository.impl;

import org.amaap.troopsimulator.domain.Troop;
import org.amaap.troopsimulator.domain.model.Archer;
import org.amaap.troopsimulator.domain.model.Barbarian;
import org.amaap.troopsimulator.repository.TroopRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryRepository implements TroopRepository {
    List<Barbarian> barbarianList = new ArrayList<>();
    List<Archer> archerList = new ArrayList<>();

    @Override
    public void insert(int troopCount, String troopType) {
        Troop troopEnum = null;
        for (Troop troop : Troop.values()) {
            if (troop.getTypeName().equals(troopType)) {
                troopEnum = troop;
                break;
            }
        }

        if (troopEnum == null) {
            throw new IllegalArgumentException("Invalid troop type: " + troopType);
        }

        for (int i = 0; i < troopCount; i++) {
            if (troopEnum == Troop.Barbarian) {
                barbarianList.add(new Barbarian());
            } else if (troopEnum == Troop.Archer) {
                archerList.add(new Archer());
            }
        }
    }

    @Override
    public List<Barbarian> getBarbarians() {
        return barbarianList;
    }

    @Override
    public List<Archer> getArchers() {
        return archerList;
    }
}
