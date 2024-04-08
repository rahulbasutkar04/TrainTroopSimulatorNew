package org.amaap.troopsimulator.controller;

import org.amaap.troopsimulator.controller.dto.HttpStatus;
import org.amaap.troopsimulator.controller.dto.Response;
import org.amaap.troopsimulator.domain.model.Barbarian;
import org.amaap.troopsimulator.repository.impl.InMemoryRepository;
import org.amaap.troopsimulator.repository.impl.database.implementation.FakeDatabase;
import org.amaap.troopsimulator.service.BarrackService;
import org.amaap.troopsimulator.service.TroopService;
import org.amaap.troopsimulator.service.exception.InvalidTroopCountException;
import org.amaap.troopsimulator.service.exception.InvalidTroopTypeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BarrackControllerTest {
    private BarrackService barrackService;
    private BarrackController barrackController;
    private TroopService troopService;


    @BeforeEach
    void setup() {
        troopService = new TroopService(new InMemoryRepository(new FakeDatabase()));
        barrackService = new BarrackService();
        barrackController = new BarrackController(troopService,barrackService);
    }

    @Test
    void shouldBeAbleToReturnOkResponseWhenTroopersSentToBarrack() throws InvalidTroopCountException, InvalidTroopTypeException {
        // arrange
        int troopCount = 10;
        String troopType = "Barbarian";
        troopService.create(troopCount,troopType);
        Response expected = new Response(HttpStatus.OK);

        // act
        List<Object> troopers = troopService.getTroopers();
        Response actual = barrackController.addTrooperToBarrack(troopers);

        // assert
        assertEquals(expected, actual);
    }
    @Test
    void shouldBeAbleToTakeFirstTenInstancesWhileTrainingTroopsInBarrack(){
        // arrange
        List<Object> troopers = troopService.getTroopers();
        Queue<Object> waitingTroopers = new ArrayDeque<>(troopers);
        Response expected = new Response(HttpStatus.OK);
        // act
        Response actual = barrackController.train(waitingTroopers);

        // assert
        assertEquals(expected,actual);
    }
}
