package org.amaap.troopsimulator.service;

import org.amaap.troopsimulator.service.exception.InvalidTroopCountException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class TroopServiceTest {

    @Test
    void shouldBeAbleToThrowErrorWhenInvalidNumberCountOfTroopIsGiven() {
        // arrange
        TroopService troopService = new TroopService();

        // act & assert
        assertThrows(InvalidTroopCountException.class, () -> {
            troopService.create(-1, "Barbarian");
        });
    }

//    @Test
//
//    void shouldBeAbleToCrateTheNumberOfBarbarians() throws InvalidTroopCountException {
//        // arrange
//        TroopService troopService=new TroopService();
//         int troopCount=10;
//         String troopType="Barbarian";
//        // act
//        troopService.create(troopCount,troopType);
//
//       List<Barbarian> actual= troopService.getBarbarians();
//
//        // assert
//
//        assertEquals(10,actual.size());
//    }


}