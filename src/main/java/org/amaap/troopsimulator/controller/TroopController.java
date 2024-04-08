package org.amaap.troopsimulator.controller;

import org.amaap.troopsimulator.controller.dto.HttpStatus;
import org.amaap.troopsimulator.controller.dto.Response;
import org.amaap.troopsimulator.service.TroopService;
import org.amaap.troopsimulator.service.exception.InvalidTroopCountException;
import org.amaap.troopsimulator.service.exception.InvalidTroopTypeException;

import static org.amaap.troopsimulator.controller.validator.TroopNameValidator.isTroopTypeValid;

public class TroopController {
    private TroopService troopService;
    public TroopController(TroopService troopService) {
        this.troopService = troopService;
    }

    public Response createTroop(int troopCount, String troopType) throws InvalidTroopCountException, InvalidTroopTypeException {
        if (isTroopTypeValid(troopType) && troopCount > 0) {
            troopService.create(troopCount, troopType);
            return new Response(HttpStatus.OK);
        }
        return new Response(HttpStatus.BADREQUEST);
    }


}

