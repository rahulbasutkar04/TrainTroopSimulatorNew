package org.amaap.troopsimulator.repository;

import org.amaap.troopsimulator.service.exception.InvalidTroopTypeException;

import java.util.List;

public interface TroopRepository {
    void insert(int troopCount, String troopType) throws InvalidTroopTypeException;

    List<Object> getBarbarians();

    List<Object> getArchers();

    List<Object> getTroopers();
}
