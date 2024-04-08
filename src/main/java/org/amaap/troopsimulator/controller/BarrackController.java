package org.amaap.troopsimulator.controller;

import org.amaap.troopsimulator.controller.dto.HttpStatus;
import org.amaap.troopsimulator.controller.dto.Response;
import org.amaap.troopsimulator.service.BarrackService;
import org.amaap.troopsimulator.service.TroopService;

import java.util.List;
import java.util.Queue;

public class BarrackController {
    private TroopService troopService;
    private BarrackService barrackService;

    public BarrackController(TroopService troopService, BarrackService barrackService) {
        this.troopService = troopService;
        this.barrackService = barrackService;
    }

    public Response addTrooperToBarrack(List<Object> troopers) {
        barrackService.addTrooper(troopers);
        return new Response(HttpStatus.OK);

    }

    public Response train(Queue<Object> waitingTroopers) {
        barrackService.train(waitingTroopers);
        return new Response(HttpStatus.OK);
    }
}
