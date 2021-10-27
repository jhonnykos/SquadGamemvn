package game.redgreen;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void shouldCheckWinner(){
        int speed = 0;

        boolean actual = Game.isLoser(speed);

        Assertions.assertFalse(actual, "Метод должен возвращать false если игрок не двигается");
    }

    @Test
    public void shouldCheckLoser(){
        int speed = 5;

        boolean actual = Game.isLoser(speed);

        Assertions.assertTrue(actual, "Метод должен возвращать true если игрок двигается");
    }

    @Test
    public void shouldCheckIfNegative(){
        int speed = -5;

        boolean actual = Game.isLoser(speed);

        Assertions.assertTrue(actual, "Метод должен возвращать true если скорость отрицательная");
    }

    @Test
    public void shouldCheckIfHighSpeed(){
        int speed = 10000;

        boolean actual = Game.isLoser(speed);

        Assertions.assertTrue(actual, "Метод должен работать с большой скоростью");
    }

}
