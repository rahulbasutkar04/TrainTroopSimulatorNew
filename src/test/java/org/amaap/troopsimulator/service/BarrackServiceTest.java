package org.amaap.troopsimulator.service;

import org.amaap.troopsimulator.repository.BarrackRepository;
import org.amaap.troopsimulator.repository.impl.InMemoryBarrackRepository;
import org.amaap.troopsimulator.repository.impl.InMemoryTrooperRepository;
import org.amaap.troopsimulator.repository.impl.database.implementation.FakeDatabase;
import org.amaap.troopsimulator.service.exception.InvalidTroopCountException;
import org.amaap.troopsimulator.service.exception.InvalidTroopTypeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BarrackServiceTest {
    private BarrackService barrackService;
    private TroopService troopService;


    @BeforeEach
    void setup() {
        BarrackRepository barrackRepository = new InMemoryBarrackRepository();
        troopService = new TroopService(new InMemoryTrooperRepository(new FakeDatabase()));
        barrackService = new BarrackService(troopService, barrackRepository);
    }

    @Test
    void shouldBeAbleToAddTrooperToBarrackRepository() throws InvalidTroopCountException, InvalidTroopTypeException {
        // arrange
        int troopCount = 10;
        String troopType = "Barbarian";
        troopService.create(troopCount, troopType);

        // act
        barrackService.addTrooperToBarrack(troopService.getTroopers());

        List<Object> actual = barrackService.getTrooperQueueFromBarrack();

        // assert
        assertEquals(troopService.getTroopers().size(), actual.size());
    }

    @Test
    void shouldTrainTroopersAndAddToTrainedTroopsQueue() throws InvalidTroopCountException, InvalidTroopTypeException {
        // arrange
        int numTroopers = 20;
        String troopType = "Archer";
        troopService = new TroopService(new InMemoryTrooperRepository(new FakeDatabase()));
        troopService.create(numTroopers, troopType);
        barrackService.addTrooperToBarrack(troopService.getTroopers());

        // act
        barrackService.train();
        Queue<Object> trainedTroops = barrackService.getTrainedTroops();

        // assert
        assertEquals(numTroopers, trainedTroops.size());
    }

}