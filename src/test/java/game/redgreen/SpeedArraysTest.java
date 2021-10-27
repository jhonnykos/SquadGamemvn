package game.redgreen;

import game.redgreen.SpeedArrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SpeedArraysTest {

    /*
     * If light is red
     * countLoser tests
     */
    @Test
    public void shouldReturnCountOfLosersRed() {
        SpeedArrays.isGreenLight = false;
        int[] speeds = {15, 5, 0, 0, 1, 0, 20, 2, 2};

        int actual = SpeedArrays.countLoser(speeds);
        int expected = 6;
        Assertions.assertEquals(expected, actual, "При красном свете метод должен возвращать количество выбывших");
    }

    @Test
    public void shouldReturnCountOfLosersIfAllStayRed() {
        SpeedArrays.isGreenLight = false;
        int[] speeds = {0, 0, 0, 0, 0, 0, 0, 0, 0};

        int actual = SpeedArrays.countLoser(speeds);
        int expected = 0;
        Assertions.assertEquals(expected, actual, "При красном свете метод должен возвращать нулевое количество выбывших");
    }

    @Test
    public void shouldReturnCountOfLosersIfAllMoveRed() {
        SpeedArrays.isGreenLight = false;
        int[] speeds = {15, 5, 1, 3, 1, 4, 20, 2, 2};

        int actual = SpeedArrays.countLoser(speeds);
        int expected = 9;
        Assertions.assertEquals(expected, actual, "При красном свете метод должен возвращать количество всех игроков");
    }

    @Test
    public void shouldReturnCountOfLosersIfFirstMoveRed() {
        SpeedArrays.isGreenLight = false;
        int[] speeds = {5, 0, 0, 0, 0, 0, 0, 0, 0};

        int actual = SpeedArrays.countLoser(speeds);
        int expected = 1;
        Assertions.assertEquals(expected, actual, "При красном свете метод должен возвращать 1, если выбывший первый");
    }

    @Test
    public void shouldReturnCountOfLosersIfLastMoveRed() {
        SpeedArrays.isGreenLight = false;
        int[] speeds = {0, 0, 0, 0, 0, 0, 0, 0, 7};

        int actual = SpeedArrays.countLoser(speeds);
        int expected = 1;
        Assertions.assertEquals(expected, actual, "При красном свете метод должен возвращать 1, если выбывший последний");
    }

    @Test
    public void shouldReturnCountOfLosersIfOneMoveRed() {
        SpeedArrays.isGreenLight = false;
        int[] speeds = {1};

        int actual = SpeedArrays.countLoser(speeds);
        int expected = 1;
        Assertions.assertEquals(expected, actual, "При красном свете метод должен возвращать 1, если игрок единственный и он выбыл");
    }

    @Test
    public void shouldReturnCountOfLosersIfOneStayRed() {
        SpeedArrays.isGreenLight = false;
        int[] speeds = {0};

        int actual = SpeedArrays.countLoser(speeds);
        int expected = 0;
        Assertions.assertEquals(expected, actual, "При красном свете метод должен возвращать 0, если игрок единственный и он не выбыл");
    }

    /*
     * speedLosers tests
     */
    @Test
    public void shouldReturnLosersRed() {
        SpeedArrays.isGreenLight = false;
        int[] speeds = {15, 5, 0, 0, 1, 0, 20, 2, 2};

        int[] actual = SpeedArrays.speedLosers(speeds);
        int[] expected = {15, 5, 1, 20, 2, 2};
        Assertions.assertArrayEquals(expected, actual, "При красном свете метод должен возвращать скорости выбывших");
    }

    @Test
    public void shouldReturnLosersIfAllStayRed() {
        SpeedArrays.isGreenLight = false;
        int[] speeds = {0, 0, 0, 0, 0, 0, 0, 0, 0};

        int[] actual = SpeedArrays.speedLosers(speeds);
        int[] expected = {};
        Assertions.assertArrayEquals(expected, actual, "При красном свете метод должен возвращать пустой массив скоростей выбывших");
    }

    @Test
    public void shouldReturnLosersIfAllMoveRed() {
        SpeedArrays.isGreenLight = false;
        int[] speeds = {15, 5, 1, 3, 1, 4, 20, 2, 2};

        int[] actual = SpeedArrays.speedLosers(speeds);
        int[] expected = {15, 5, 1, 3, 1, 4, 20, 2, 2};
        Assertions.assertArrayEquals(expected, actual, "При красном свете метод должен возвращать скорости всех игроков");
    }

    @Test
    public void shouldReturnLosersIfFirstMoveRed() {
        SpeedArrays.isGreenLight = false;
        int[] speeds = {5, 0, 0, 0, 0, 0, 0, 0, 0};

        int[] actual = SpeedArrays.speedLosers(speeds);
        int[] expected = {5};
        Assertions.assertArrayEquals(expected, actual, "При красном свете метод должен возвращать скорость выбывшего, если выбывший первый");
    }

    @Test
    public void shouldReturnLosersIfLastMoveRed() {
        SpeedArrays.isGreenLight = false;
        int[] speeds = {0, 0, 0, 0, 0, 0, 0, 0, 7};

        int[] actual = SpeedArrays.speedLosers(speeds);
        int[] expected = {7};
        Assertions.assertArrayEquals(expected, actual, "При красном свете метод должен возвращать скорость выбывшего, если выбывший последний");
    }

    @Test
    public void shouldReturnLosersIfOneMoveRed() {
        SpeedArrays.isGreenLight = false;
        int[] speeds = {1};

        int[] actual = SpeedArrays.speedLosers(speeds);
        int[] expected = {1};
        Assertions.assertArrayEquals(expected, actual, "При красном свете метод должен возвращать массив из одной скорости, " +
                "если игрок единственный и он выбыл");
    }

    @Test
    public void shouldReturnLosersIfOneStayRed() {
        SpeedArrays.isGreenLight = false;
        int[] speeds = {0};

        int[] actual = SpeedArrays.speedLosers(speeds);
        int[] expected = {};
        Assertions.assertArrayEquals(expected, actual, "При красном свете метод должен возвращать пустой массив, " +
                "если игрок единственный и он не выбыл");
    }

    /*
     * speedWinners tests
     */
    @Test
    public void shouldReturnWinnersRed() {
        SpeedArrays.isGreenLight = false;
        int[] speeds = {15, 5, 0, 0, 1, 0, 20, 2, 2};

        int[] actual = SpeedArrays.speedWinners(speeds);
        int[] expected = {0, 0, 0};
        Assertions.assertArrayEquals(expected, actual, "При красном свете метод должен возвращать скорости выигравших");
    }

    @Test
    public void shouldReturnWinnersIfAllMoveRed() {
        SpeedArrays.isGreenLight = false;
        int[] speeds = {15, 5, 1, 3, 1, 4, 20, 2, 2};

        int[] actual = SpeedArrays.speedWinners(speeds);
        int[] expected = {};
        Assertions.assertArrayEquals(expected, actual, "При красном свете метод должен возвращать пустой массив скоростей выигравших");
    }

    @Test
    public void shouldReturnWinnersIfAllStayRed() {
        SpeedArrays.isGreenLight = false;
        int[] speeds = {0, 0, 0, 0, 0, 0, 0, 0, 0};

        int[] actual = SpeedArrays.speedWinners(speeds);
        int[] expected = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        Assertions.assertArrayEquals(expected, actual, "При красном свете метод должен возвращать скорости всех игроков");
    }

    @Test
    public void shouldReturnWinnersIfFirstStayRed() {
        SpeedArrays.isGreenLight = false;
        int[] speeds = {0, 5, 6, 1, 10, 2, 15, 2, 5};

        int[] actual = SpeedArrays.speedWinners(speeds);
        int[] expected = {0};
        Assertions.assertArrayEquals(expected, actual, "При красном свете метод должен возвращать скорость выигравшего, " +
                "если выигравший первый");
    }

    @Test
    public void shouldReturnWinnersIfLastStayRed() {
        SpeedArrays.isGreenLight = false;
        int[] speeds = {10, 9, 8, 3, 2, 4, 3, 5, 0};

        int[] actual = SpeedArrays.speedWinners(speeds);
        int[] expected = {0};
        Assertions.assertArrayEquals(expected, actual, "При красном свете метод должен возвращать скорость выигравшего, " +
                "если выигравший последний");
    }

    @Test
    public void shouldReturnWinnersIfOneStayRed() {
        SpeedArrays.isGreenLight = false;
        int[] speeds = {0};

        int[] actual = SpeedArrays.speedWinners(speeds);
        int[] expected = {0};
        Assertions.assertArrayEquals(expected, actual, "При красном свете метод должен возвращать массив из одной скорости, " +
                "если игрок единственный и он выиграл");
    }

    @Test
    public void shouldReturnWinnersIfOneMoveRed() {
        SpeedArrays.isGreenLight = false;
        int[] speeds = {5};

        int[] actual = SpeedArrays.speedWinners(speeds);
        int[] expected = {};
        Assertions.assertArrayEquals(expected, actual, "При красном свете метод должен возвращать пустой массив, " +
                "если игрок единственный и он выбыл");
    }

    /*
     * If light is green
     * countLoser tests
     */
    @Test
    public void shouldReturnCountOfLosersGreen() {
        SpeedArrays.isGreenLight = true;
        int[] speeds = {15, 5, 0, 0, 1, 0, 20, 2, 2};

        int actual = SpeedArrays.countLoser(speeds);
        int expected = 0;
        Assertions.assertEquals(expected, actual, "При зеленом свете метод должен возвращать нулевое количество выбывших");
    }

    @Test
    public void shouldReturnCountOfLosersIfAllStayGreen() {
        SpeedArrays.isGreenLight = true;
        int[] speeds = {0, 0, 0, 0, 0, 0, 0, 0, 0};

        int actual = SpeedArrays.countLoser(speeds);
        int expected = 0;
        Assertions.assertEquals(expected, actual, "При зеленом свете метод должен возвращать нулевое количество выбывших");
    }

    @Test
    public void shouldReturnCountOfLosersIfAllMoveGreen() {
        SpeedArrays.isGreenLight = true;
        int[] speeds = {15, 5, 1, 3, 1, 4, 20, 2, 2};

        int actual = SpeedArrays.countLoser(speeds);
        int expected = 0;
        Assertions.assertEquals(expected, actual, "При зеленом свете метод должен возвращать нулевое количество выбывших");
    }

    @Test
    public void shouldReturnCountOfLosersIfOneMoveGreen() {
        SpeedArrays.isGreenLight = true;
        int[] speeds = {1};

        int actual = SpeedArrays.countLoser(speeds);
        int expected = 0;
        Assertions.assertEquals(expected, actual, "При зеленом свете метод должен возвращать нулевое количество выбывших");
    }

    @Test
    public void shouldReturnCountOfLosersIfOneStayGreen() {
        SpeedArrays.isGreenLight = true;
        int[] speeds = {0};

        int actual = SpeedArrays.countLoser(speeds);
        int expected = 0;
        Assertions.assertEquals(expected, actual, "При зеленом свете метод должен возвращать нулевое количество выбывших");
    }

    /*
     * speedLosers tests
     */
    @Test
    public void shouldReturnLosersGreen() {
        SpeedArrays.isGreenLight = true;
        int[] speeds = {15, 5, 0, 0, 1, 0, 20, 2, 2};

        int[] actual = SpeedArrays.speedLosers(speeds);
        int[] expected = {};
        Assertions.assertArrayEquals(expected, actual, "При зеленом свете метод должен возвращать пустой массив");
    }

    @Test
    public void shouldReturnLosersIfAllStayGreen() {
        SpeedArrays.isGreenLight = true;
        int[] speeds = {0, 0, 0, 0, 0, 0, 0, 0, 0};

        int[] actual = SpeedArrays.speedLosers(speeds);
        int[] expected = {};
        Assertions.assertArrayEquals(expected, actual, "При зеленом свете метод должен возвращать пустой массив");
    }

    @Test
    public void shouldReturnLosersIfAllMoveGreen() {
        SpeedArrays.isGreenLight = true;
        int[] speeds = {15, 5, 1, 3, 1, 4, 20, 2, 2};

        int[] actual = SpeedArrays.speedLosers(speeds);
        int[] expected = {};
        Assertions.assertArrayEquals(expected, actual, "При зеленом свете метод должен возвращать пустой массив");
    }

    @Test
    public void shouldReturnLosersIfOneMoveGreen() {
        SpeedArrays.isGreenLight = true;
        int[] speeds = {1};

        int[] actual = SpeedArrays.speedLosers(speeds);
        int[] expected = {};
        Assertions.assertArrayEquals(expected, actual, "При зеленом свете метод должен возвращать пустой массив");
    }

    @Test
    public void shouldReturnLosersIfOneStayGreen() {
        SpeedArrays.isGreenLight = true;
        int[] speeds = {0};

        int[] actual = SpeedArrays.speedLosers(speeds);
        int[] expected = {};
        Assertions.assertArrayEquals(expected, actual, "При зеленом свете метод должен возвращать пустой массив");
    }

    /*
     * speedWinners tests
     */
    @Test
    public void shouldReturnWinnersGreen() {
        SpeedArrays.isGreenLight = true;
        int[] speeds = {15, 5, 0, 0, 1, 0, 20, 2, 2};

        int[] actual = SpeedArrays.speedWinners(speeds);
        int[] expected = {15, 5, 0, 0, 1, 0, 20, 2, 2};
        Assertions.assertArrayEquals(expected, actual, "При зеленом свете метод должен возвращать скорости всех игроков");
    }

    @Test
    public void shouldReturnWinnersIfAllMoveGreen() {
        SpeedArrays.isGreenLight = true;
        int[] speeds = {15, 5, 1, 3, 1, 4, 20, 2, 2};

        int[] actual = SpeedArrays.speedWinners(speeds);
        int[] expected =  {15, 5, 1, 3, 1, 4, 20, 2, 2};
        Assertions.assertArrayEquals(expected, actual, "При зеленом свете метод должен возвращать скорости всех игроков");
    }

    @Test
    public void shouldReturnWinnersIfAllStayGreen() {
        SpeedArrays.isGreenLight = true;
        int[] speeds = {0, 0, 0, 0, 0, 0, 0, 0, 0};

        int[] actual = SpeedArrays.speedWinners(speeds);
        int[] expected = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        Assertions.assertArrayEquals(expected, actual, "При зеленом свете метод должен возвращать скорости всех игроков");
    }

    @Test
    public void shouldReturnWinnersIfOneStayGreen() {
        SpeedArrays.isGreenLight = true;
        int[] speeds = {0};

        int[] actual = SpeedArrays.speedWinners(speeds);
        int[] expected = {0};
        Assertions.assertArrayEquals(expected, actual, "При зеленом свете метод должен возвращать скорости всех игроков");
    }

    @Test
    public void shouldReturnWinnersIfOneMoveGreen() {
        SpeedArrays.isGreenLight = true;
        int[] speeds = {5};

        int[] actual = SpeedArrays.speedWinners(speeds);
        int[] expected = {5};
        Assertions.assertArrayEquals(expected, actual, "При зеленом свете метод должен возвращать скорости всех игроков");
    }

}
