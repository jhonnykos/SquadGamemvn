package game.redgreen;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameManagerTest {

    @Test
    void shouldReturnRoundsWinCountRed() {
        Game game = new Game(false);
        GameManager manager = new GameManager(game);
        int[] speeds = {0, 0, 0, 0, 0, 1, 5, 5, 6};
        int expected = 5;
        int actual = manager.roundsWinCount(speeds);
        Assertions.assertEquals(expected, actual, "Метод должен возвращать количество выигранных раундов " +
                "при красном свете");
    }

    @Test
    void shouldReturnRoundsWinCountIfStayAfterMoveRed() {
        Game game = new Game(false);
        GameManager manager = new GameManager(game);
        int[] speeds = {0, 0, 0, 0, 0, 1, 5, 0, 6};
        int expected = 5;
        int actual = manager.roundsWinCount(speeds);
        Assertions.assertEquals(expected, actual, "Метод должен возвращать количество выигранных раундов " +
                "до первого проигранного при красном свете");
    }

    @Test
    void shouldReturnRoundsWinCountGreen() {
        Game game = new Game(true);
        GameManager manager = new GameManager(game);
        int[] speeds = {0, 0, 0, 0, 0, 1, 5, 0, 6};
        int expected = 9;
        int actual = manager.roundsWinCount(speeds);
        Assertions.assertEquals(expected, actual, "Метод должен возвращать количество всех раундов " +
                "при зеленом свете");
    }

    @Test
    void shouldReturnRoundsWinCountWithMaxSpeedRed() {
        Game game = new SpeedyGame(false, 10);
        GameManager manager = new GameManager(game);
        int[] speeds = {0, 0, 0, 0, 0, 1, 10, 15, 6};
        int expected = 7;
        int actual = manager.roundsWinCount(speeds);
        Assertions.assertEquals(expected, actual, "Метод должен возвращать количество выигранных раундов " +
                "при красном свете");
    }

    @Test
    void shouldReturnRoundsWinCountWithMaxSpeedIfStayAfterMoveRed() {
        Game game = new SpeedyGame(false, 10);
        GameManager manager = new GameManager(game);
        int[] speeds = {0, 0, 0, 0, 0, 10, 11, 5, 16};
        int expected = 6;
        int actual = manager.roundsWinCount(speeds);
        Assertions.assertEquals(expected, actual, "Метод должен возвращать количество выигранных раундов " +
                "до первого проигранного при красном свете");
    }

    @Test
    void shouldReturnRoundsWinCountWithMaxSpeedGreen() {
        Game game = new SpeedyGame(true, 10);
        GameManager manager = new GameManager(game);
        int[] speeds = {0, 0, 0, 0, 0, 1, 10, 15, 6};
        int expected = 9;
        int actual = manager.roundsWinCount(speeds);
        Assertions.assertEquals(expected, actual, "Метод должен возвращать количество выигранных раундов" +
                " при красном свете");
    }

}