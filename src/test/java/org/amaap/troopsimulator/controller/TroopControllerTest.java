package org.amaap.troopsimulator.controller;

import org.amaap.troopsimulator.controller.dto.HttpStatus;
import org.amaap.troopsimulator.controller.dto.Response;
import org.amaap.troopsimulator.repository.impl.InMemoryRepository;
import org.amaap.troopsimulator.repository.impl.database.implementation.FakeDatabase;
import org.amaap.troopsimulator.service.TroopService;
import org.amaap.troopsimulator.service.exception.InvalidTroopCountException;
import org.amaap.troopsimulator.service.exception.InvalidTroopTypeException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TroopControllerTest {
    TroopController troopController = new TroopController(new TroopService(new InMemoryRepository(new FakeDatabase())));


    @Test
    void shouldBeAbleToCreateTroopAndGetOKResponse() throws InvalidTroopCountException, InvalidTroopTypeException {
        // arrange
        int troopCount = 10;
        String troopType = "Barbarian";

        Response expected = new Response(HttpStatus.OK);

        // act
        Response actual = troopController.createTroop(troopCount, troopType);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToGetBadRequestIfInvalidTroopTypeIsGiven() throws InvalidTroopCountException, InvalidTroopTypeException {
        // arrange
        int troopCount = 10;
        String troopType = "Trunkers";

        Response expected = new Response(HttpStatus.BADREQUEST);

        // act
        Response actual = troopController.createTroop(troopCount, troopType);

        // assert
        assertEquals(expected, actual);
    }


}
