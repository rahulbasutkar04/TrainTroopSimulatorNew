package org.amaap.troopsimulator.controller.validator;

import org.amaap.troopsimulator.controller.TroopController;
import org.junit.jupiter.api.Test;

import static org.amaap.troopsimulator.controller.validator.TroopNameValidator.isTroopTypeValid;
import static org.junit.jupiter.api.Assertions.*;

class TroopNameValidatorTest {
    @Test
    void shouldBeAbleToRecognizeValidTroopType(){

        assertTrue(isTroopTypeValid("Barbarian"));
        assertTrue(isTroopTypeValid("Archer"));
    }
    @Test
    void shouldBeAbleToReturnFalseWhenInvalidTroopTypeIsPassed(){

        assertFalse(isTroopTypeValid("Magician"));
        assertFalse(isTroopTypeValid("Cooker"));
    }

}