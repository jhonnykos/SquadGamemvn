package game.redgreen;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpeedyGameTest {

    @Test
    void getMaxSpeedRed() {
        SpeedyGame sGame = new SpeedyGame(false, 10);
        int expected = 10;
        int actual = sGame.getMaxSpeed();
        Assertions.assertEquals(expected, actual, "Метод должен возвращать максимальную скорость при красном свете");
    }

    @Test
    void getMaxSpeedGreen() {
        SpeedyGame sGame = new SpeedyGame(true, 10);
        int expected = 10;
        int actual = sGame.getMaxSpeed();
        Assertions.assertEquals(expected, actual, "Метод должен возвращать максимальную скорость при зеленом свете");
    }

    @Test
    void getMaxSpeedIfZeroRed() {
        SpeedyGame sGame = new SpeedyGame(false, 0);
        int expected = 0;
        int actual = sGame.getMaxSpeed();
        Assertions.assertEquals(expected, actual, "Метод должен возвращать максимальную скорость если она равна 0");
    }

    @Test
    void getMaxSpeedIfZeroGreen() {
        SpeedyGame sGame = new SpeedyGame(true, 0);
        int expected = 0;
        int actual = sGame.getMaxSpeed();
        Assertions.assertEquals(expected, actual, "Метод должен возвращать максимальную скорость если она равна 0");
    }

    @Test
    void setMaxSpeedIfSameRed() {
        int maxSpeed1 = 10;
        int maxSpeed2 = 10;
        SpeedyGame sGame = new SpeedyGame(false, maxSpeed1);
        sGame.setMaxSpeed(maxSpeed2);
        int expected = 10;
        int actual = sGame.getMaxSpeed();
        Assertions.assertEquals(expected, actual, "Метод должен менять максимальную скорость на ту же " +
                "если свет красный");
    }

    @Test
    void setMaxSpeedIfSameGreen() {
        int maxSpeed1 = 10;
        int maxSpeed2 = 10;
        SpeedyGame sGame = new SpeedyGame(true, maxSpeed1);
        sGame.setMaxSpeed(maxSpeed2);
        int expected = 10;
        int actual = sGame.getMaxSpeed();
        Assertions.assertEquals(expected, actual, "Метод должен менять максимальную скорость на ту же " +
                "если свет зеленый");
    }

    @Test
    void setMaxSpeedIfDiffRed() {
        int maxSpeed1 = 10;
        int maxSpeed2 = 5;
        SpeedyGame sGame = new SpeedyGame(false, maxSpeed1);
        sGame.setMaxSpeed(maxSpeed2);
        int expected = 5;
        int actual = sGame.getMaxSpeed();
        Assertions.assertEquals(expected, actual, "Метод должен менять максимальную скорость на новую " +
                "если свет красный");
    }

    @Test
    void setMaxSpeedIfDiffGreen() {
        int maxSpeed1 = 10;
        int maxSpeed2 = 5;
        SpeedyGame sGame = new SpeedyGame(true, maxSpeed1);
        sGame.setMaxSpeed(maxSpeed2);
        int expected = 5;
        int actual = sGame.getMaxSpeed();
        Assertions.assertEquals(expected, actual, "Метод должен менять максимальную скорость на новую " +
                "если свет зеленый");
    }

    @Test
    void shouldReturnFailIfMoveRed() {
        SpeedyGame sGame = new SpeedyGame(false,10);
        int speed = 15;
        boolean actual = sGame.isFailed(speed);
        Assertions.assertTrue(actual, "Метод должен возвращать true если свет красный " +
                "и скорость игрока больше максимальной");
    }

    @Test
    void shouldReturnFailIfStayRed() {
        SpeedyGame sGame = new SpeedyGame(false,10);
        int speed = 5;
        boolean actual = sGame.isFailed(speed);
        Assertions.assertFalse(actual, "Метод должен возвращать false если свет красный " +
                "и скорость игрока меньше максимальной");
    }

    @Test
    void shouldReturnFailIfMaxRed() {
        SpeedyGame sGame = new SpeedyGame(false,10);
        int speed = 10;
        boolean actual = sGame.isFailed(speed);
        Assertions.assertFalse(actual, "Метод должен возвращать false если свет красный " +
                "и скорость игрока равна максимальной");
    }

    @Test
    void shouldReturnFailIfMaxIsZeroRed() {
        SpeedyGame sGame = new SpeedyGame(false,0);
        int speed = 5;
        boolean actual = sGame.isFailed(speed);
        Assertions.assertTrue(actual, "Метод должен возвращать false если свет красный" +
                " и максимальная скорость равна 0");
    }

    @Test
    void shouldReturnFailIfMoveGreen() {
        SpeedyGame sGame = new SpeedyGame(true,10);
        int speed = 15;
        boolean actual = sGame.isFailed(speed);
        Assertions.assertFalse(actual, "Метод должен возвращать false если свет зеленый");
    }

    @Test
    void shouldReturnFailIfStayGreen() {
        SpeedyGame sGame = new SpeedyGame(true,10);
        int speed = 5;
        boolean actual = sGame.isFailed(speed);
        Assertions.assertFalse(actual, "Метод должен возвращать false если свет зеленый");
    }

    @Test
    void shouldReturnFailIfMaxGreen() {
        SpeedyGame sGame = new SpeedyGame(false,10);
        int speed = 10;
        boolean actual = sGame.isFailed(speed);
        Assertions.assertFalse(actual, "Метод должен возвращать false если свет зеленый");
    }

    @Test
    void shouldReturnFailIfMaxIsZeroGreen() {
        SpeedyGame sGame = new SpeedyGame(true,0);
        int speed = 5;
        boolean actual = sGame.isFailed(speed);
        Assertions.assertFalse(actual, "Метод должен возвращать false если свет зеленый");
    }
}