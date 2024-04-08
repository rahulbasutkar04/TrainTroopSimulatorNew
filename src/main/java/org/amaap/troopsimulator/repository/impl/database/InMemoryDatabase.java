package org.amaap.troopsimulator.repository.impl.database;

import java.util.List;

public interface InMemoryDatabase {

    void insertIntoTroopTable(int troopCount,String troopType);

    List<Object> getTroopers();

}