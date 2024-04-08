package org.amaap.troopsimulator.repository;

import org.amaap.troopsimulator.domain.model.Archer;
import org.amaap.troopsimulator.domain.model.Barbarian;

import java.util.List;

public interface TroopRepository  {
    public void insert(int troopCount, String troopType);

    public List<Barbarian> getBarbarians();

    public List<Archer> getArchers();
}
