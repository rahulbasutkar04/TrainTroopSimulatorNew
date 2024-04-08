package org.amaap.troopsimulator.controller.validator;

import org.amaap.troopsimulator.domain.Troop;

public class TroopNameValidator {

    public static boolean isTroopTypeValid(String troopType) {
        for (Troop troop : Troop.values()) {
            if (troop.name().equalsIgnoreCase(troopType)) {
                return true;
            }
        }
        return false;
    }

}
