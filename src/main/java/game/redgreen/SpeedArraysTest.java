package game.redgreen;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SpeedArraysTest {

    @Test
    public void shouldReturnCountOfLosers() {
        int[] speeds = {15, 5, 0, 0, 1, 0, 20, 2, 2};

        int actual = SpeedArrays.countLoser(speeds);
        int expected = 6;
        Assertions.assertEquals(expected, actual, "Метод должен возвращать количество выбывших");
    }

    @Test
    public void shouldReturnCountOfLosersIfNoOne() {
        int[] speeds = {0, 0, 0, 0, 0, 0, 0, 0, 0};

        int actual = SpeedArrays.countLoser(speeds);
        int expected = 0;
        Assertions.assertEquals(expected, actual, "Метод должен возвращать нулевое количество выбывших");
    }

    @Test
    public void shouldReturnCountOfLosersIfEveryOne() {
        int[] speeds = {15, 5, 1, 3, 1, 4, 20, 2, 2};

        int actual = SpeedArrays.countLoser(speeds);
        int expected = 9;
        Assertions.assertEquals(expected, actual, "Метод должен возвращать количество всех игроков");
    }

    @Test
    public void shouldReturnCountOfLosersIfFirst() {
        int[] speeds = {5, 0, 0, 0, 0, 0, 0, 0, 0};

        int actual = SpeedArrays.countLoser(speeds);
        int expected = 1;
        Assertions.assertEquals(expected, actual, "Метод должен возвращать количество выбывших, если выбывший первый");
    }

    @Test
    public void shouldReturnCountOfLosersIfLast() {
        int[] speeds = {0, 0, 0, 0, 0, 0, 0, 0, 7};

        int actual = SpeedArrays.countLoser(speeds);
        int expected = 1;
        Assertions.assertEquals(expected, actual, "Метод должен возвращать количество выбывших, если выбывший последний");
    }

    @Test
    public void shouldReturnCountOfLosersIfOne() {
        int[] speeds = {1};

        int actual = SpeedArrays.countLoser(speeds);
        int expected = 1;
        Assertions.assertEquals(expected, actual, "Метод должен возвращать 1, если игрок единственный и он выбыл");
    }

    @Test
    public void shouldReturnCountOfLosersIfOneWin() {
        int[] speeds = {0};

        int actual = SpeedArrays.countLoser(speeds);
        int expected = 0;
        Assertions.assertEquals(expected, actual, "Метод должен возвращать 0, если игрок единственный и он не выбыл");
    }

    @Test
    public void shouldReturnLosers() {
        int[] speeds = {15, 5, 0, 0, 1, 0, 20, 2, 2};

        int[] actual = SpeedArrays.speedLosers(speeds);
        int[] expected = {15, 5, 1, 20, 2, 2};
        Assertions.assertArrayEquals(expected, actual, "Метод должен возвращать скорости выбывших");
    }

    @Test
    public void shouldReturnLosersIfNoOne() {
        int[] speeds = {0, 0, 0, 0, 0, 0, 0, 0, 0};

        int[] actual = SpeedArrays.speedLosers(speeds);
        int[] expected = {};
        Assertions.assertArrayEquals(expected, actual, "Метод должен возвращать пустой массив скоростей выбывших");
    }

    @Test
    public void shouldReturnLosersIfEveryOne() {
        int[] speeds = {15, 5, 1, 3, 1, 4, 20, 2, 2};

        int[] actual = SpeedArrays.speedLosers(speeds);
        int[] expected = {15, 5, 1, 3, 1, 4, 20, 2, 2};
        Assertions.assertArrayEquals(expected, actual, "Метод должен возвращать скорости всех игроков");
    }

    @Test
    public void shouldReturnLosersIfFirst() {
        int[] speeds = {5, 0, 0, 0, 0, 0, 0, 0, 0};

        int[] actual = SpeedArrays.speedLosers(speeds);
        int[] expected = {5};
        Assertions.assertArrayEquals(expected, actual, "Метод должен возвращать скорости выбывших, если выбывший первый");
    }

    @Test
    public void shouldReturnLosersIfLast() {
        int[] speeds = {0, 0, 0, 0, 0, 0, 0, 0, 7};

        int[] actual = SpeedArrays.speedLosers(speeds);
        int[] expected = {7};
        Assertions.assertArrayEquals(expected, actual, "Метод должен возвращать скорости выбывших, если выбывший последний");
    }

    @Test
    public void shouldReturnLosersIfOne() {
        int[] speeds = {1};

        int[] actual = SpeedArrays.speedLosers(speeds);
        int[] expected = {1};
        Assertions.assertArrayEquals(expected, actual, "Метод должен возвращать массив из одной скорости, " +
                "если игрок единственный и он выбыл");
    }

    @Test
    public void shouldReturnLosersIfOneWin() {
        int[] speeds = {0};

        int[] actual = SpeedArrays.speedLosers(speeds);
        int[] expected = {};
        Assertions.assertArrayEquals(expected, actual, "Метод должен возвращать пустой массив, " +
                "если игрок единственный и он не выбыл");
    }

    @Test
    public void shouldReturnWinners() {
        int[] speeds = {15, 5, 0, 0, 1, 0, 20, 2, 2};

        int[] actual = SpeedArrays.speedWinners(speeds);
        int[] expected = {0, 0, 0};
        Assertions.assertArrayEquals(expected, actual, "Метод должен возвращать скорости выигравших");
    }

    @Test
    public void shouldReturnWinnersIfNoOne() {
        int[] speeds = {15, 5, 1, 3, 1, 4, 20, 2, 2};

        int[] actual = SpeedArrays.speedWinners(speeds);
        int[] expected = {};
        Assertions.assertArrayEquals(expected, actual, "Метод должен возвращать пустой массив скоростей выигравших");
    }

    @Test
    public void shouldReturnWinnersIfEveryOne() {
        int[] speeds = {0, 0, 0, 0, 0, 0, 0, 0, 0};

        int[] actual = SpeedArrays.speedWinners(speeds);
        int[] expected = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        Assertions.assertArrayEquals(expected, actual, "Метод должен возвращать скорости всех игроков");
    }

    @Test
    public void shouldReturnWinnersIfFirst() {
        int[] speeds = {0, 5, 6, 1, 10, 2, 15, 2, 5};

        int[] actual = SpeedArrays.speedWinners(speeds);
        int[] expected = {0};
        Assertions.assertArrayEquals(expected, actual, "Метод должен возвращать скорости выигравших, " +
                "если выигравший первый");
    }

    @Test
    public void shouldReturnWinnersIfLast() {
        int[] speeds = {10, 9, 8, 3, 2, 4, 3, 5, 0};

        int[] actual = SpeedArrays.speedWinners(speeds);
        int[] expected = {0};
        Assertions.assertArrayEquals(expected, actual, "Метод должен возвращать скорости выигравших, " +
                "если выигравший последний");
    }

    @Test
    public void shouldReturnWinnersIfOne() {
        int[] speeds = {0};

        int[] actual = SpeedArrays.speedWinners(speeds);
        int[] expected = {0};
        Assertions.assertArrayEquals(expected, actual, "Метод должен возвращать массив из одной скорости, " +
                "если игрок единственный и он выиграл");
    }

    @Test
    public void shouldReturnWinnersIfOneLose() {
        int[] speeds = {5};

        int[] actual = SpeedArrays.speedWinners(speeds);
        int[] expected = {};
        Assertions.assertArrayEquals(expected, actual, "Метод должен возвращать пустой массив, " +
                "если игрок единственный и он выбыл");
    }

}
