package game.redgreen;

import game.redgreen.Game;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    /*
     * If light is red
     */
    @Test
    public void shouldCheckWinnerRed(){
        Game.isGreenLight = false;
        int speed = 0;

        boolean actual = Game.isLoser(speed);

        Assertions.assertFalse(actual, "При красном свете метод должен возвращать false если игрок не двигается");
    }

    @Test
    public void shouldCheckLoserRed(){
        Game.isGreenLight = false;
        int speed = 5;

        boolean actual = Game.isLoser(speed);

        Assertions.assertTrue(actual, "При красном свете метод должен возвращать true если игрок двигается");
    }

    @Test
    public void shouldCheckIfNegativeRed(){
        Game.isGreenLight = false;
        int speed = -5;

        boolean actual = Game.isLoser(speed);

        Assertions.assertTrue(actual, "При красном свете метод должен возвращать true если скорость отрицательная");
    }

    @Test
    public void shouldCheckIfHighSpeedRed(){
        Game.isGreenLight = false;
        int speed = 10000;

        boolean actual = Game.isLoser(speed);

        Assertions.assertTrue(actual, "При красном свете метод должен работать с большой скоростью");
    }

    /*
     * If light is green
     */
    @Test
    public void shouldCheckWinnerGreen(){
        Game.isGreenLight = true;
        int speed = 0;

        boolean actual = Game.isLoser(speed);

        Assertions.assertFalse(actual, "При зеленом свете метод должен возвращать false если игрок не двигается");
    }

    @Test
    public void shouldCheckLoserGreen(){
        Game.isGreenLight = true;
        int speed = 5;

        boolean actual = Game.isLoser(speed);

        Assertions.assertFalse(actual, "При зеленом свете метод должен возвращать false если игрок двигается");
    }

    @Test
    public void shouldCheckIfNegativeGreen(){
        Game.isGreenLight = true;
        int speed = -5;

        boolean actual = Game.isLoser(speed);

        Assertions.assertFalse(actual, "При зеленом свете метод должен возвращать false если скорость отрицательная");
    }

    @Test
    public void shouldCheckIfHighSpeedGreen(){
        Game.isGreenLight = true;
        int speed = 10000;

        boolean actual = Game.isLoser(speed);

        Assertions.assertFalse(actual, "При зеленом свете метод должен работать с большой скоростью");
    }

}
