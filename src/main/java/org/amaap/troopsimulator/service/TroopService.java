package org.amaap.troopsimulator.service;

import org.amaap.troopsimulator.domain.Troop;
import org.amaap.troopsimulator.domain.model.Archer;
import org.amaap.troopsimulator.domain.model.Barbarian;
import org.amaap.troopsimulator.repository.TroopRepository;
import org.amaap.troopsimulator.service.exception.InvalidTroopCountException;
import org.amaap.troopsimulator.service.exception.InvalidTroopTypeException;

import java.util.List;


public class TroopService {

    private final TroopRepository troopRepository;

    public TroopService(TroopRepository troopRepository) {
        this.troopRepository = troopRepository;
    }

    public void create(int troopCount, String troopType) throws InvalidTroopCountException, InvalidTroopTypeException {
        if (troopCount <= 0) throw new InvalidTroopCountException("Troop count can not be:" + troopCount);
        troopRepository.insert(troopCount, troopType);
    }

    public List<Barbarian> getBarbarians() {
        return troopRepository.getBarbarians();
    }


    public List<Archer> getArchers() {
        return troopRepository.getArchers();
    }
}
