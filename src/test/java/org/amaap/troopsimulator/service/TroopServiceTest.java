package org.amaap.troopsimulator.service;

import org.amaap.troopsimulator.domain.model.Archer;
import org.amaap.troopsimulator.domain.model.Barbarian;
import org.amaap.troopsimulator.repository.impl.InMemoryRepository;
import org.amaap.troopsimulator.repository.impl.database.implementation.FakeDatabase;
import org.amaap.troopsimulator.service.exception.InvalidTroopCountException;
import org.amaap.troopsimulator.service.exception.InvalidTroopTypeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TroopServiceTest {
    private TroopService troopService;
    @BeforeEach
    void setup() {
      troopService = new TroopService(new InMemoryRepository(new FakeDatabase()));
    }

    @Test
    void shouldBeAbleToThrowErrorWhenInvalidNumberCountOfTroopIsGiven() {
        // arrange

        // act & assert
        assertThrows(InvalidTroopCountException.class, () -> {
            troopService.create(-1, "Barbarian");
        });
    }
    @Test
    void shouldBeAbleToCrateTheNumberOfBarbarians() throws InvalidTroopCountException, InvalidTroopTypeException {
        // arrange
        int troopCount = 10;
        String troopType = "Barbarian";

        // act
        troopService.create(troopCount, troopType);
        List<Object> actual = troopService.getBarbarians();

        // assert

        assertEquals(10, actual.size());
    }

    @Test
    void shouldBeAbleToCrateTheNumberOfArchers() throws InvalidTroopCountException, InvalidTroopTypeException {
        // arrange
        int troopCount = 10;
        String troopType = "Archer";

        // act
        troopService.create(troopCount, troopType);
        List<Object> actual = troopService.getArchers();

        // assert

        assertEquals(10, actual.size());
    }
}