package game.redgreen;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameIsLoserTest {

    /*
     * If light is red
     */
    @Test
    public void shouldCheckWinnerRed() {
        GameIsLoser.isGreenLight = false;
        int speed = 0;

        boolean actual = GameIsLoser.isLoser(speed);
        Assertions.assertFalse(actual, "При красном свете метод должен возвращать false если игрок не двигается");
    }

    @Test
    public void shouldCheckLoserRed() {
        GameIsLoser.isGreenLight = false;
        int speed = 5;

        boolean actual = GameIsLoser.isLoser(speed);
        Assertions.assertTrue(actual, "При красном свете метод должен возвращать true если игрок двигается");
    }

    @Test
    public void shouldCheckIfNegativeRed() {
        GameIsLoser.isGreenLight = false;
        int speed = -5;

        boolean actual = GameIsLoser.isLoser(speed);
        Assertions.assertTrue(actual, "При красном свете метод должен возвращать true если скорость отрицательная");
    }

    @Test
    public void shouldCheckIfHighSpeedRed() {
        GameIsLoser.isGreenLight = false;
        int speed = 10000;

        boolean actual = GameIsLoser.isLoser(speed);
        Assertions.assertTrue(actual, "При красном свете метод должен работать с большой скоростью");
    }

    /*
     * If light is green
     */
    @Test
    public void shouldCheckWinnerGreen() {
        GameIsLoser.isGreenLight = true;
        int speed = 0;

        boolean actual = GameIsLoser.isLoser(speed);
        Assertions.assertFalse(actual, "При зеленом свете метод должен возвращать false если игрок не двигается");
    }

    @Test
    public void shouldCheckLoserGreen() {
        GameIsLoser.isGreenLight = true;
        int speed = 5;

        boolean actual = GameIsLoser.isLoser(speed);
        Assertions.assertFalse(actual, "При зеленом свете метод должен возвращать false если игрок двигается");
    }

    @Test
    public void shouldCheckIfNegativeGreen() {
        GameIsLoser.isGreenLight = true;
        int speed = -5;

        boolean actual = GameIsLoser.isLoser(speed);
        Assertions.assertFalse(actual, "При зеленом свете метод должен возвращать false если скорость отрицательная");
    }

    @Test
    public void shouldCheckIfHighSpeedGreen() {
        GameIsLoser.isGreenLight = true;
        int speed = 10000;

        boolean actual = GameIsLoser.isLoser(speed);
        Assertions.assertFalse(actual, "При зеленом свете метод должен работать с большой скоростью");
    }
}
