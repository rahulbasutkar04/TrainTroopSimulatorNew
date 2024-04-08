package org.amaap.troopsimulator.controller.controller;

import org.amaap.troopsimulator.controller.controller.dto.HttpStatus;
import org.amaap.troopsimulator.controller.controller.dto.Response;

public class TroopController {
        public Response createTroop(int troopCount, String troopType) {
            if (isTroopTypeValid(troopType)) {
                if (isTroopTypeValid(troopType)) {
                    TroopService.create(troopCount, troopType);
                    return new Response(HttpStatus.OK);
                }
            }
                return new Response(HttpStatus.BADREQUEST);


        }
        private boolean isTroopTypeValid(String troopType) {
            for (Troop troop : Troop.values()) {
                if (troop.name().equalsIgnoreCase(troopType)) {
                    return true;
                }
            }
            return false;
        }

    }

