package org.amaap.troopsimulator.controller;

import org.amaap.troopsimulator.controller.controller.TroopController;
import org.amaap.troopsimulator.controller.controller.dto.HttpStatus;
import org.amaap.troopsimulator.controller.controller.dto.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TroopControllerTest {

    @Test
    void shouldBeAbleToCreateTroop() {
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
}
