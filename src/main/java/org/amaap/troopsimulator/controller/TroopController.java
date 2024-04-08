package org.amaap.troopsimulator.controller;

import org.amaap.troopsimulator.controller.dto.HttpStatus;
import org.amaap.troopsimulator.controller.dto.Response;
import org.amaap.troopsimulator.service.TroopService;
import org.amaap.troopsimulator.service.exception.InvalidTroopCountException;

import static org.amaap.troopsimulator.controller.validator.TroopNameValidator.isTroopTypeValid;

public class TroopController {


    public Response createTroop(int troopCount, String troopType) throws InvalidTroopCountException {
        if (isTroopTypeValid(troopType)) {

            TroopService.create(troopCount, troopType);

            return new Response(HttpStatus.OK);
        }

        return new Response(HttpStatus.BADREQUEST);


    }


}

