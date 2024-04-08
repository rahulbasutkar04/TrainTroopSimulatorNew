package org.amaap.troopsimulator.repository.impl.database.implementation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.amaap.troopsimulator.domain.model.Archer;
import org.amaap.troopsimulator.domain.model.Barbarian;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FakeDatabaseTest {
    FakeDatabase database = new FakeDatabase();
    @Test
    void shouldBeAbleToInsertBarbariansIntoDatabase() {
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
    void shouldBeAbleToInsertArchersIntoDatabase() {
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
    void shouldContainOnlyBarbariansInDatabase() {
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
    void shouldContainOnlyArchersInDatabase() {
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
        assertThrows(IllegalArgumentException.class, () -> {
            database.insertIntoTroopTable(troopCount, invalidTroopType);
        });
    }
}
