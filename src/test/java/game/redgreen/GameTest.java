package game.redgreen;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void shouldReturnFailMoveIfRed() {
        Game game = new Game(false);
        int speed = 5;
        boolean actual = game.isFailed(speed);
        Assertions.assertTrue(actual, "Метод должен возвращать true если свет красный и игрок двигается");
    }

    @Test
    void shouldReturnFailStayIfRed() {
        Game game = new Game(false);
        int speed = 0;
        boolean actual = game.isFailed(speed);
        Assertions.assertFalse(actual, "Метод должен возвращать false если свет красный и игрок стоит");
    }

    @Test
    void shouldReturnFailStayIfHighRed() {
        Game game = new Game(false);
        int speed = 10000;
        boolean actual = game.isFailed(speed);
        Assertions.assertTrue(actual, "Метод должен возвращать true если свет красный " +
                "и игрок двигается с большой скоростью");
    }

    @Test
    void shouldReturnFailMoveIfGreen() {
        Game game = new Game(true);
        int speed = 5;
        boolean actual = game.isFailed(speed);
        Assertions.assertFalse(actual, "Метод должен возвращать false если свет зеленый");
    }

    @Test
    void shouldReturnFailStayIfGreen() {
        Game game = new Game(true);
        int speed = 5;
        boolean actual = game.isFailed(speed);
        Assertions.assertFalse(actual, "Метод должен возвращать false если свет зеленый");
    }

    @Test
    void shouldReturnFailStayIfGreenHigh() {
        Game game = new Game(true);
        int speed = 10000;
        boolean actual = game.isFailed(speed);
        Assertions.assertFalse(actual, "Метод должен возвращать false если свет зеленый");
    }

    @Test
    void shouldReturnIsGreenLightTrue() {
        Game game = new Game(true);
        boolean actual = game.isGreenLight();
        Assertions.assertTrue(actual, "Геттер должен возвращать true если в качестве параметра " +
                "конструктора был передан true");
    }

    @Test
    void shouldReturnIsGreenLightFalse() {
        Game game = new Game(false);
        boolean actual = game.isGreenLight();
        Assertions.assertFalse(actual, "Геттер должен возвращать false если в качестве параметра " +
                "конструктора был передан false");
    }

    @Test
    void setGreenLightIfSame() {
        boolean isGreenLight1 = true;
        boolean isGreenLight2 = true;
        Game game = new Game(isGreenLight1);
        game.setGreenLight(isGreenLight2);
        boolean actual = game.isGreenLight();
        Assertions.assertTrue(actual, "Сеттер должен менять поле на то же самое");
    }

    @Test
    void setGreenLightIfDiff() {
        boolean isGreenLight1 = true;
        boolean isGreenLight2 = false;
        Game game = new Game(isGreenLight1);
        game.setGreenLight(isGreenLight2);
        boolean actual = game.isGreenLight();
        Assertions.assertFalse(actual, "Сеттер должен менять поле на другое");
    }
}