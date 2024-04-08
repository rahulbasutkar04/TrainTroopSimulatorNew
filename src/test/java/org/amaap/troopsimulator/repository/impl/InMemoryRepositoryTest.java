package org.amaap.troopsimulator.repository.impl;

import org.amaap.troopsimulator.repository.impl.database.implementation.FakeDatabase;
import org.amaap.troopsimulator.service.exception.InvalidTroopTypeException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InMemoryRepositoryTest {
    @Test
    void shouldBeAbleToInsertBarbariansIntoDatabase() {
        // arrange
        InMemoryRepository repository = new InMemoryRepository(new FakeDatabase());
        int troopCount = 10;
        String troopType = "Barbarian";

        // act
        repository.insert(troopCount, troopType);
        int actualBarbarianCount = repository.getBarbarians().size();

        // assert
        assertEquals(troopCount, actualBarbarianCount);
    }

    @Test
    void shouldBeAbleToInsertArchersIntoDatabase() {
        // arrange
        InMemoryRepository repository = new InMemoryRepository(new FakeDatabase());
        int troopCount = 10;
        String troopType = "Archer";

        // act
        repository.insert(troopCount, troopType);
        int actualArcherCount = repository.getArchers().size();

        // assert
        assertEquals(troopCount, actualArcherCount);
    }

    @Test
    void shouldThrowExceptionForInvalidTroopType() {
        // arrange
        InMemoryRepository repository = new InMemoryRepository(new FakeDatabase());
        int troopCount = 10;
        String invalidTroopType = "InvalidTroopType";

        // act & assert
        assertThrows(InvalidTroopTypeException.class, () -> {
            repository.insert(troopCount, invalidTroopType);
        });
    }
}
