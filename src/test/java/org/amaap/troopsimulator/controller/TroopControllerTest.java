package org.amaap.troopsimulator.controller;

import org.amaap.troopsimulator.controller.dto.HttpStatus;
import org.amaap.troopsimulator.controller.dto.Response;
import org.amaap.troopsimulator.service.exception.InvalidTroopCountException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TroopControllerTest {

    @Test
    void shouldBeAbleToCreateTroopAndGetOkResponse() throws InvalidTroopCountException {
        // arrange
        int troopCount = 10;
        String troopType = "Barbarian";

        TroopController troopController = new TroopController();
        Response expected = new Response(HttpStatus.OK);

        // act
        Response actual = troopController.createTroop(troopCount, troopType);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToGetBadRequestIfInvalidTroopTypeIsGiven() throws InvalidTroopCountException {
        // arrange
        int troopCount = 10;
        String troopType = "Trunkers";

        TroopController troopController = new TroopController();
        Response expected = new Response(HttpStatus.BADREQUEST);

        // act
        Response actual = troopController.createTroop(troopCount, troopType);

        // assert
        assertEquals(expected, actual);
    }


}
