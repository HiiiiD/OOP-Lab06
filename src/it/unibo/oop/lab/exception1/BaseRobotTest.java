package it.unibo.oop.lab.exception1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * Testing class for PositionOutOfBound.
 * 
 */
public final class BaseRobotTest {

    /**
     * Simple test for testing a robot moving, wandering the available
     * environment.
     * 
     */
    @Test
    public void testRobotMovementBase() {
        /*
         * FIRST OF ALL, take a look to "TestWithExceptions". Read the source and the
         * comments very carefully.
         */
        /*
         *  1) Create a Robot with battery level 100
         */
        final Robot r1 = new Robot("SimpleRobot", 100);
        // checking if robot is in position x=0; y=0
        assertEquals("[CHECKING ROBOT INIT POS X]", 0, r1.getEnvironment().getCurrPosX());
        assertEquals("[CHECKING ROBOT INIT POS Y]", 0, r1.getEnvironment().getCurrPosY());
        /*
         * 2) Move the robot right until it touches the world limit
         */
        for (int i = 0; i < RobotEnvironment.WORLD_X_UPPER_LIMIT; i++) {
            // check if position if coherent
            assertTrue("[CHECKING MOVING RIGHT]", r1.moveRight());
        }
        try {
			r1.moveRight();
			fail("Reached the right limit");
		} catch (PositionOutOfBoundException e) {
			assertNotNull(e.getMessage());
		}
        // checking positions x=50; y=0
        assertEquals("[MOVING RIGHT ROBOT POS X]", RobotEnvironment.WORLD_X_UPPER_LIMIT, r1.getEnvironment().getCurrPosX());
        assertEquals("[MOVING RIGHT ROBOT POS Y]", 0, r1.getEnvironment().getCurrPosY());
        /*
         * 2) Move to the top until it reaches the upper right conrner of the world
         */
        for (int i = 0; i < RobotEnvironment.WORLD_Y_UPPER_LIMIT; i++) {
            // check if position if coherent
            assertTrue("[CHECKING MOVING UP]", r1.moveUp());
        }
        try {
			r1.moveRight();
			fail("Reached the top limit");
		} catch (PositionOutOfBoundException e) {
			assertNotNull(e.getMessage());
		}
        
        //After doing 100 steps, battery is not enough to move (considering Robot.MOVEMENT_DELTA is 1)
        try {
			r1.moveDown();
		} catch (NotEnoughBatteryException e) {
			assertNotNull(e.getMessage());
		}
    }

    /**
     * Simple test for testing robot battery.
     * 
     */
    @Test
    public void testRobotBatteryBase() {
        final Robot r2 = new Robot("SimpleRobot2", 20);
        /*
         * Repeatedly move the robot up and down until the battery is completely
         * exhausted.
         */
        while (r2.getBatteryLevel() > 0) {
            r2.moveUp();
            r2.moveDown();
        }
        
        try {
			r2.moveDown();
			fail("You are supposed to have no battery left");
		} catch (NotEnoughBatteryException e) {
			assertNotNull(e.getMessage());
		}
    }
}
