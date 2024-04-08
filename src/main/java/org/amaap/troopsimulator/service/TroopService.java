package org.amaap.troopsimulator.service;

import org.amaap.troopsimulator.repository.TroopRepository;
import org.amaap.troopsimulator.service.exception.InvalidTroopCountException;

import java.util.List;

public class TroopService {

    private final TroopRepository troopRepository;

    public TroopService(TroopRepository troopRepository) {
        this.troopRepository = troopRepository;
    }

    public void create(int troopCount, String troopType) throws InvalidTroopCountException {
        if (troopCount <= 0) throw new InvalidTroopCountException("Troop count can not be:" + troopCount);
        troopRepository.insert(troopCount, troopType);
    }

    public List<Object> getBarbarians() {
        return troopRepository.getBarbarians();
    }


    public List<Object> getArchers() {
        return troopRepository.getArchers();
    }
}
