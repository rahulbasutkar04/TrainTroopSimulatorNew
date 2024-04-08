package org.amaap.troopsimulator.repository.impl.database.implementation;

import static org.junit.jupiter.api.Assertions.*;

import org.amaap.troopsimulator.service.exception.InvalidTroopTypeException;
import org.junit.jupiter.api.Test;
import org.amaap.troopsimulator.domain.model.Archer;
import org.amaap.troopsimulator.domain.model.Barbarian;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FakeDatabaseTest {
    FakeDatabase database = new FakeDatabase();
    @Test
    void shouldBeAbleToInsertBarbariansIntoDatabase() throws InvalidTroopTypeException {
        // arrange
        int troopCount = 10;
        String troopType = "Barbarian";

        // act
        database.insertIntoTroopTable(troopCount, troopType);
        int actualBarbarianCount = database.getTroopers().size();

        // assert
        assertEquals(troopCount, actualBarbarianCount);
    }

    @Test
    void shouldBeAbleToInsertArchersIntoDatabase() throws InvalidTroopTypeException {
        // arrange
        int troopCount = 10;
        String troopType = "Archer";

        // act
        database.insertIntoTroopTable(troopCount, troopType);
        int actualArcherCount = database.getTroopers().size();

        // assert
        assertEquals(troopCount, actualArcherCount);
    }

    @Test
    void shouldContainOnlyBarbariansInDatabase() throws InvalidTroopTypeException {
        // arrange
        int troopCount = 5;
        String troopType = "Barbarian";

        // act
        database.insertIntoTroopTable(troopCount, troopType);

        // assert
        for (Object trooper : database.getTroopers()) {
            assertEquals(Barbarian.class, trooper.getClass());
        }
    }

    @Test
    void shouldContainOnlyArchersInDatabase() throws InvalidTroopTypeException {
        // arrange
        int archerCount = 5;
        String archerType = "Archer";

        // act
        database.insertIntoTroopTable(archerCount, archerType);

        // assert
        for (Object trooper : database.getTroopers()) {
            assertEquals(Archer.class, trooper.getClass());
        }
    }

    @Test
    void shouldThrowExceptionForInvalidTroopType() {
        // arrange
        int troopCount = 10;
        String invalidTroopType = "InvalidTroopType";

        // act & assert
        assertThrows(InvalidTroopTypeException.class, () -> {
            database.insertIntoTroopTable(troopCount, invalidTroopType);
        });
    }
    @Test
    void shouldBeAbleToGetTroopers() throws InvalidTroopTypeException {
        // arrange
        FakeDatabase database = new FakeDatabase();
        int barbarianCount = 5;
        int archerCount = 5;
        String barbarianType = "Barbarian";
        String archerType = "Archer";

        // act
        database.insertIntoTroopTable(barbarianCount, barbarianType);
        database.insertIntoTroopTable(archerCount, archerType);
        List<Object> troopers = database.getTroopers();

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
