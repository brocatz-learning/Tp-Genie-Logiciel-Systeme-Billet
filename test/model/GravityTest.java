package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GravityTest {

    @Test
    void testGravity() {
        Gravity gravity = Gravity.Faible;
        assertEquals(1, gravity.getId());
    }

}