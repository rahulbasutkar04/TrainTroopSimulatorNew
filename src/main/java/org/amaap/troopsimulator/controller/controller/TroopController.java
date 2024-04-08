package org.amaap.troopsimulator.controller.controller;

import org.amaap.troopsimulator.controller.controller.dto.HttpStatus;
import org.amaap.troopsimulator.controller.controller.dto.Response;

public class TroopController {
    public Response createTroop(int troopCount, String troopType) {

        return new Response(HttpStatus.OK);

    }
}
