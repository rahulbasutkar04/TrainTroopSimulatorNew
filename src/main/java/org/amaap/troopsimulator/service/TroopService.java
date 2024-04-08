package org.amaap.troopsimulator.service;

import org.amaap.troopsimulator.service.exception.InvalidTroopCountException;

public class TroopService {
    public static void create(int troopCount, String troopType) throws InvalidTroopCountException {


        if (troopCount <= 0) throw new InvalidTroopCountException("Troop count can not be:" + troopCount);



    }


}
