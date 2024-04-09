package org.amaap.troopsimulator.repository.impl;

import org.amaap.troopsimulator.domain.model.Archer;
import org.amaap.troopsimulator.domain.model.Barbarian;
import org.amaap.troopsimulator.repository.impl.database.implementation.FakeDatabase;
import org.amaap.troopsimulator.service.exception.InvalidTroopTypeException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InMemoryRepositoryTest {
    @Test
    void shouldBeAbleToInsertBarbariansIntoDatabase() throws InvalidTroopTypeException {
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
    void shouldBeAbleToInsertArchersIntoDatabase() throws InvalidTroopTypeException {
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
    @Test
    void shouldBeAbleToGetTroopers() throws InvalidTroopTypeException {
        // arrange
        FakeDatabase database = new FakeDatabase();
        InMemoryRepository repository = new InMemoryRepository(database);
        int barbarianCount = 5;
        int archerCount = 5;
        String barbarianType = "Barbarian";
        String archerType = "Archer";

        // act
        database.insertIntoTroopTable(barbarianCount, barbarianType);
        database.insertIntoTroopTable(archerCount, archerType);
        List<Object> troopers = repository.getTroopers();

        // assert
        assertEquals(10, troopers.size());
        int barbarianCountInTroopers = 0;
        int archerCountInTroopers = 0;
        for (Object trooper : troopers) {
            if (trooper instanceof Barbarian) {
                barbarianCountInTroopers++;
            } else if (trooper instanceof Archer) {
                archerCountInTroopers++;
            }
        }
        assertEquals(barbarianCount, barbarianCountInTroopers);
        assertEquals(archerCount, archerCountInTroopers);
    }
}
