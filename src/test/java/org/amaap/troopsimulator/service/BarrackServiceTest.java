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

import static org.junit.jupiter.api.Assertions.assertEquals;

class BarrackServiceTest {
    private BarrackService barrackService;
    private TroopService troopService;


    @BeforeEach
    void setup() {
        BarrackRepository barrackRepository = new InMemoryBarrackRepository();
        troopService = new TroopService(new InMemoryTrooperRepository(new FakeDatabase()));
        barrackService = new BarrackService(troopService,barrackRepository);
    }

    @Test
    void shouldBeAbleToAddTrooperToBarrackRepository() throws InvalidTroopCountException, InvalidTroopTypeException {
        // arrange
        int troopCount = 10;
        String troopType = "Barbarian";
        troopService.create(troopCount, troopType);

        // act
        barrackService.addTrooperToBarrack(troopService.getTroopers());

        List<Object> actual = barrackService.getTrooperQueueInBarrack();

        // assert
        assertEquals(troopService.getTroopers().size(), actual.size());
    }

}