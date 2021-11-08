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

    /*
     * Losers
     */

    @Test
    void shouldReturnLoserIfFirstRed() {
        Game game = new Game(false);
        GameManager manager = new GameManager(game);
        Movable p1 = new FastPlayer(0, 2);
        Movable p2 = new ConstantPlayer(0);
        int expected = -1;
        int actual = manager.loser(p1, p2, game, 5);
        Assertions.assertEquals(expected, actual, "Метод должен возвращать первого выбывшего игрока");
    }

    @Test
    void shouldReturnLoserIfSecondRed() {
        Game game = new Game(false);
        GameManager manager = new GameManager(game);
        Movable p1 = new ConstantPlayer(0);
        Movable p2 = new FastPlayer(0, 2);
        int expected = 1;
        int actual = manager.loser(p1, p2, game, 5);
        Assertions.assertEquals(expected, actual, "Метод должен возвращать первого выбывшего игрока");
    }

    @Test
    void shouldReturnLoserIfNoOneRed() {
        Game game = new Game(false);
        GameManager manager = new GameManager(game);
        Movable p1 = new FastPlayer(0, 0);
        Movable p2 = new ConstantPlayer(0);
        int expected = 0;
        int actual = manager.loser(p1, p2, game, 5);
        Assertions.assertEquals(expected, actual, "Метод должен возвращать 0, если ни один игрок не выбыл");
    }

    @Test
    void shouldReturnLoserConstFastRed() {
        Game game = new Game(false);
        GameManager manager = new GameManager(game);
        Movable p1 = new ConstantPlayer(0);
        Movable p2 = new FastPlayer(0, 2);
        int expected = 1;
        int actual = manager.loser(p1, p2, game, 5);
        Assertions.assertEquals(expected, actual, "Метод должен возвращать первого выбывшего игрока, " +
                "если игроки разных типов");
    }

    @Test
    void shouldReturnLoserConstFastIfStayRed() {
        Game game = new Game(false);
        GameManager manager = new GameManager(game);
        Movable p1 = new ConstantPlayer(0);
        Movable p2 = new FastPlayer(0, 0);
        int expected = 0;
        int actual = manager.loser(p1, p2, game, 5);
        Assertions.assertEquals(expected, actual, "Метод должен возвращать 0,если игроки стоят");
    }

    @Test
    void shouldReturnLoserConstRed() {
        Game game = new Game(false);
        GameManager manager = new GameManager(game);
        Movable p1 = new ConstantPlayer(0);
        Movable p2 = new ConstantPlayer(5);
        int expected = 1;
        int actual = manager.loser(p1, p2, game, 5);
        Assertions.assertEquals(expected, actual, "Метод должен возвращать первого выбывшего игрока, " +
                "если игроки одного типа");
    }

    @Test
    void shouldReturnLoserConstIfStayRed() {
        Game game = new Game(false);
        GameManager manager = new GameManager(game);
        Movable p1 = new ConstantPlayer(0);
        Movable p2 = new ConstantPlayer(0);
        int expected = 0;
        int actual = manager.loser(p1, p2, game, 5);
        Assertions.assertEquals(expected, actual, "Метод должен возвращать 0,если игроки стоят");
    }

    @Test
    void shouldReturnLoserFastRed() {
        Game game = new Game(false);
        GameManager manager = new GameManager(game);
        Movable p1 = new FastPlayer(0, 0);
        Movable p2 = new FastPlayer(0, 5);
        int expected = 1;
        int actual = manager.loser(p1, p2, game, 5);
        Assertions.assertEquals(expected, actual, "Метод должен возвращать первого выбывшего игрока, " +
                "если игроки одного типа");
    }

    @Test
    void shouldReturnLoserFastIfStayRed() {
        Game game = new Game(false);
        GameManager manager = new GameManager(game);
        Movable p1 = new FastPlayer(0, 0);
        Movable p2 = new FastPlayer(0, 0);
        int expected = 0;
        int actual = manager.loser(p1, p2, game, 5);
        Assertions.assertEquals(expected, actual, "Метод должен возвращать 0,если игроки стоят");
    }

    @Test
    void shouldReturnLoserWithMaxSpeedIfFirstRed() {
        Game game = new SpeedyGame(false, 10);
        GameManager manager = new GameManager(game);
        Movable p1 = new ConstantPlayer(11);
        Movable p2 = new FastPlayer(9, 2);
        int expected = -1;
        int actual = manager.loser(p1, p2, game, 6);
        Assertions.assertEquals(expected, actual, "Метод должен возвращать первого выбывшего игрока, " +
                "если есть максимальная скорость");
    }

    @Test
    void shouldReturnLoserWithMaxSpeedIfSecondRed() {
        Game game = new SpeedyGame(false, 10);
        GameManager manager = new GameManager(game);
        Movable p1 = new ConstantPlayer(5);
        Movable p2 = new FastPlayer(5, 2);
        int expected = 1;
        int actual = manager.loser(p1, p2, game, 6);
        Assertions.assertEquals(expected, actual, "Метод должен возвращать первого выбывшего игрока, " +
                "если есть максимальная скорость");
    }

    @Test
    void shouldReturnLoserWithMaxSpeedIfNoOneRed() {
        Game game = new SpeedyGame(false, 10);
        GameManager manager = new GameManager(game);
        Movable p1 = new ConstantPlayer(5);
        Movable p2 = new FastPlayer(5, 1);
        int expected = 0;
        int actual = manager.loser(p1, p2, game, 6);
        Assertions.assertEquals(expected, actual, "Метод должен возвращать 0, " +
                "если есть максимальная скорость и если никто не выбыл");
    }

    @Test
    void shouldReturnLoserWithMaxSpeedConstFastRed() {
        Game game = new SpeedyGame(false, 10);
        GameManager manager = new GameManager(game);
        Movable p1 = new ConstantPlayer(5);
        Movable p2 = new FastPlayer(1, 2);
        int expected = 1;
        int actual = manager.loser(p1, p2, game, 6);
        Assertions.assertEquals(expected, actual, "Метод должен возвращать первого выбывшего игрока, " +
                "если игроки разного типа и если есть максимальная скорость");
    }

    @Test
    void shouldReturnLoserWithMaxSpeedConstFastIfStayRed() {
        Game game = new SpeedyGame(false, 10);
        GameManager manager = new GameManager(game);
        Movable p1 = new ConstantPlayer(5);
        Movable p2 = new FastPlayer(7, 0);
        int expected = 0;
        int actual = manager.loser(p1, p2, game, 6);
        Assertions.assertEquals(expected, actual, "Метод должен возвращать 0, " +
                "если скорость игроков после всех раундов меньше или равна максимальной");
    }

    @Test
    void shouldReturnLoserWithMaxSpeedConstRed() {
        Game game = new SpeedyGame(false, 10);
        GameManager manager = new GameManager(game);
        Movable p1 = new ConstantPlayer(5);
        Movable p2 = new ConstantPlayer(11);
        int expected = 1;
        int actual = manager.loser(p1, p2, game, 6);
        Assertions.assertEquals(expected, actual, "Метод должен возвращать первого выбывшего игрока, " +
                "если игроки одного типа и если есть максимальная скорость");
    }

    @Test
    void shouldReturnLoserWithMaxSpeedConstIfStayRed() {
        Game game = new SpeedyGame(false, 10);
        GameManager manager = new GameManager(game);
        Movable p1 = new ConstantPlayer(5);
        Movable p2 = new ConstantPlayer(10);
        int expected = 0;
        int actual = manager.loser(p1, p2, game, 6);
        Assertions.assertEquals(expected, actual, "Метод должен возвращать 0, " +
                "если скорость игроков меньше или равна максимальной");
    }

    @Test
    void shouldReturnLoserWithMaxSpeedFastRed() {
        Game game = new SpeedyGame(false, 10);
        GameManager manager = new GameManager(game);
        Movable p1 = new FastPlayer(5, 2);
        Movable p2 = new FastPlayer(1, 1);
        int expected = -1;
        int actual = manager.loser(p1, p2, game, 6);
        Assertions.assertEquals(expected, actual, "Метод должен возвращать первого выбывшего игрока, " +
                "если игроки одного типа и если есть максимальная скорость");
    }

    @Test
    void shouldReturnLoserWithMaxSpeedFastIfStayRed() {
        Game game = new SpeedyGame(false, 10);
        GameManager manager = new GameManager(game);
        Movable p1 = new FastPlayer(5, 1);
        Movable p2 = new FastPlayer(1, 1);
        int expected = 0;
        int actual = manager.loser(p1, p2, game, 6);
        Assertions.assertEquals(expected, actual, "Метод должен возвращать 0, " +
                "если скорость игроков после всех раундов меньше или равна максимальной");
    }

    @Test
    void shouldReturnLoserIfNoRoundRed() {
        Game game = new SpeedyGame(false, 10);
        GameManager manager = new GameManager(game);
        Movable p1 = new FastPlayer(5, 1);
        Movable p2 = new FastPlayer(1, 1);
        int expected = 0;
        int actual = manager.loser(p1, p2, game, 0);
        Assertions.assertEquals(expected, actual, "Метод должен возвращать 0, " +
                "если количество раундов равно 0");
    }

    @Test
    void shouldReturnLoserWithMaxSpeedFastIfNoRoundRed() {
        Game game = new SpeedyGame(false, 10);
        GameManager manager = new GameManager(game);
        Movable p1 = new FastPlayer(5, 1);
        Movable p2 = new FastPlayer(1, 1);
        int expected = 0;
        int actual = manager.loser(p1, p2, game, 0);
        Assertions.assertEquals(expected, actual, "Метод должен возвращать 0, " +
                "если количество раундов равно 0");
    }

    @Test
    void shouldReturnLoserConstFastGreen() {
        Game game = new Game(true);
        GameManager manager = new GameManager(game);
        Movable p1 = new ConstantPlayer(5);
        Movable p2 = new FastPlayer(5, 5);
        int expected = 0;
        int actual = manager.loser(p1, p2, game, 5);
        Assertions.assertEquals(expected, actual, "Метод должен возвращать 0, " +
                "если свет зеленый");
    }

    @Test
    void shouldReturnLoserConstGreen() {
        Game game = new Game(true);
        GameManager manager = new GameManager(game);
        Movable p1 = new ConstantPlayer(5);
        Movable p2 = new ConstantPlayer(0);
        int expected = 0;
        int actual = manager.loser(p1, p2, game, 5);
        Assertions.assertEquals(expected, actual, "Метод должен возвращать 0, " +
                "если свет зеленый");
    }

    @Test
    void shouldReturnLoserFastGreen() {
        Game game = new Game(true);
        GameManager manager = new GameManager(game);
        Movable p1 = new FastPlayer(5, 1);
        Movable p2 = new FastPlayer(0, 5);
        int expected = 0;
        int actual = manager.loser(p1, p2, game, 5);
        Assertions.assertEquals(expected, actual, "Метод должен возвращать 0, " +
                "если свет зеленый");
    }

    @Test
    void shouldReturnLoserIfFirstGreen() {
        Game game = new Game(true);
        GameManager manager = new GameManager(game);
        Movable p1 = new FastPlayer(0, 5);
        Movable p2 = new ConstantPlayer(0);
        int expected = 0;
        int actual = manager.loser(p1, p2, game, 5);
        Assertions.assertEquals(expected, actual, "Метод должен возвращать 0, " +
                "если свет зеленый");
    }

    @Test
    void shouldReturnLoserIfSecondGreen() {
        Game game = new Game(true);
        GameManager manager = new GameManager(game);
        Movable p1 = new ConstantPlayer(0);
        Movable p2 = new FastPlayer(0, 5);
        int expected = 0;
        int actual = manager.loser(p1, p2, game, 5);
        Assertions.assertEquals(expected, actual, "Метод должен возвращать 0, " +
                "если свет зеленый");
    }

    @Test
    void shouldReturnLoserIfNoOneGreen() {
        Game game = new Game(true);
        GameManager manager = new GameManager(game);
        Movable p1 = new ConstantPlayer(0);
        Movable p2 = new FastPlayer(0, 0);
        int expected = 0;
        int actual = manager.loser(p1, p2, game, 5);
        Assertions.assertEquals(expected, actual, "Метод должен возвращать 0, " +
                "если свет зеленый");
    }
}