package org.amaap.troopsimulator.repository.impl.database;

import org.amaap.troopsimulator.service.exception.InvalidTroopTypeException;

import java.util.List;

public interface InMemoryDatabase {

    void insertIntoTroopTable(int troopCount,String troopType) throws InvalidTroopTypeException;

    List<Object> getTroopers();

}