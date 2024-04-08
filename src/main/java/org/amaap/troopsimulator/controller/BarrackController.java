package org.amaap.troopsimulator.controller;

import org.amaap.troopsimulator.controller.dto.Response;
import org.amaap.troopsimulator.service.BarrackService;
import org.amaap.troopsimulator.service.TroopService;

import java.util.List;

public class BarrackController {
    private TroopService troopService;
    private BarrackService barrackService;

    public BarrackController(TroopService troopService, BarrackService barrackService) {
        this.troopService = troopService;
        this.barrackService = barrackService;
    }

    public Response addTrooperToBarrack(List<Object> troopers) {
        return null;
    }
}
