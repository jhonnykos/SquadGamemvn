package game.redgreen;

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
        SpeedArrays.MAX_SPEED = 10;
        int[] speeds = {15, 16, 5, 5, 17, 5, 18, 19, 20};

        int expected = 6;
        int actual = SpeedArrays.countLoser(speeds);
        Assertions.assertEquals(expected, actual, "При красном свете метод должен возвращать количество выбывших");
    }

    @Test
    public void shouldReturnCountOfLosersIfAllStayRed() {
        SpeedArrays.isGreenLight = false;
        SpeedArrays.MAX_SPEED = 10;
        int[] speeds = {5, 5, 5, 5, 5, 5, 5, 5, 5};

        int expected = 0;
        int actual = SpeedArrays.countLoser(speeds);
        Assertions.assertEquals(expected, actual, "При красном свете метод должен возвращать нулевое количество выбывших");
    }

    @Test
    public void shouldReturnCountOfLosersIfAllMoveRed() {
        SpeedArrays.isGreenLight = false;
        SpeedArrays.MAX_SPEED = 10;
        int[] speeds = {15, 16, 17, 18, 19, 20, 21, 22, 23};

        int expected = 9;
        int actual = SpeedArrays.countLoser(speeds);
        Assertions.assertEquals(expected, actual, "При красном свете метод должен возвращать количество всех игроков");
    }

    @Test
    public void shouldReturnCountOfLosersIfFirstMoveRed() {
        SpeedArrays.isGreenLight = false;
        SpeedArrays.MAX_SPEED = 10;
        int[] speeds = {15, 5, 5, 5, 5, 5, 5, 5, 5};

        int expected = 1;
        int actual = SpeedArrays.countLoser(speeds);
        Assertions.assertEquals(expected, actual, "При красном свете метод должен возвращать 1, если выбывший первый");
    }

    @Test
    public void shouldReturnCountOfLosersIfLastMoveRed() {
        SpeedArrays.isGreenLight = false;
        SpeedArrays.MAX_SPEED = 10;
        int[] speeds = {5, 5, 5, 5, 5, 5, 5, 5, 15};

        int expected = 1;
        int actual = SpeedArrays.countLoser(speeds);
        Assertions.assertEquals(expected, actual, "При красном свете метод должен возвращать 1, если выбывший последний");
    }

    @Test
    public void shouldReturnCountOfLosersIfOneMoveRed() {
        SpeedArrays.isGreenLight = false;
        SpeedArrays.MAX_SPEED = 10;
        int[] speeds = {15};

        int expected = 1;
        int actual = SpeedArrays.countLoser(speeds);
        Assertions.assertEquals(expected, actual, "При красном свете метод должен возвращать 1, если игрок единственный и он выбыл");
    }

    @Test
    public void shouldReturnCountOfLosersIfOneStayRed() {
        SpeedArrays.isGreenLight = false;
        SpeedArrays.MAX_SPEED = 10;
        int[] speeds = {5};

        int expected = 0;
        int actual = SpeedArrays.countLoser(speeds);
        Assertions.assertEquals(expected, actual, "При красном свете метод должен возвращать 0, если игрок единственный и он не выбыл");
    }

    @Test
    public void shouldReturnCountOfLosersLBStayRed() {
        SpeedArrays.isGreenLight = false;
        SpeedArrays.MAX_SPEED = 10;
        int[] speeds = {15, 15, 15, 0, 15, 15, 15};

        int expected = 6;
        int actual = SpeedArrays.countLoser(speeds);
        Assertions.assertEquals(expected, actual, "При красном свете и игроке с нижней границей скорости выигрышего " +
                "метод должен возвращать количество выбывших");
    }

    @Test
    public void shouldReturnCountOfLosersUBStayRed() {
        SpeedArrays.isGreenLight = false;
        SpeedArrays.MAX_SPEED = 10;
        int[] speeds = {15, 15, 15, 10, 15, 15, 15};

        int expected = 6;
        int actual = SpeedArrays.countLoser(speeds);
        Assertions.assertEquals(expected, actual, "При красном свете и игроке с верхней границей скорости выигрышего " +
                "метод должен возвращать количество выбывших");
    }

    @Test
    public void shouldReturnCountOfLosersLBMoveRed() {
        SpeedArrays.isGreenLight = false;
        SpeedArrays.MAX_SPEED = 10;
        int[] speeds = {5, 5, 11, 5, 5, 5, 5};

        int expected = 1;
        int actual = SpeedArrays.countLoser(speeds);
        Assertions.assertEquals(expected, actual, "При красном свете и игроке с нижней границей скорости выбывшего " +
                "метод должен возвращать количество выбывших");
    }

    @Test
    public void shouldReturnCountOfLosersIfMaxIsZeroRed() {
        SpeedArrays.isGreenLight = false;
        SpeedArrays.MAX_SPEED = 0;
        int[] speeds = {5, 5, 0, 5, 5, 5, 5};

        int expected = 6;
        int actual = SpeedArrays.countLoser(speeds);
        Assertions.assertEquals(expected, actual, "При красном свете и MAX = 0 метод должен возвращать количество выбывших");
    }

    /*
     * speedLosers tests
     */
    @Test
    public void shouldReturnLosersRed() {
        SpeedArrays.isGreenLight = false;
        SpeedArrays.MAX_SPEED = 10;
        int[] speeds = {15, 16, 5, 5, 5, 5, 11, 20, 5};

        int[] expected = {15, 16, 11, 20};
        int[] actual = SpeedArrays.speedLosers(speeds);
        Assertions.assertArrayEquals(expected, actual, "При красном свете метод должен возвращать скорости выбывших");
    }

    @Test
    public void shouldReturnLosersIfAllStayRed() {
        SpeedArrays.isGreenLight = false;
        SpeedArrays.MAX_SPEED = 10;
        int[] speeds = {5, 5, 5, 5, 5, 5, 5, 5, 5};

        int[] expected = {};
        int[] actual = SpeedArrays.speedLosers(speeds);
        Assertions.assertArrayEquals(expected, actual, "При красном свете метод должен возвращать пустой массив скоростей выбывших");
    }

    @Test
    public void shouldReturnLosersIfAllMoveRed() {
        SpeedArrays.isGreenLight = false;
        SpeedArrays.MAX_SPEED = 10;
        int[] speeds = {15, 16, 17, 18, 19, 20, 21, 22, 23};

        int[] expected = {15, 16, 17, 18, 19, 20, 21, 22, 23};
        int[] actual = SpeedArrays.speedLosers(speeds);
        Assertions.assertArrayEquals(expected, actual, "При красном свете метод должен возвращать скорости всех игроков");
    }

    @Test
    public void shouldReturnLosersIfFirstMoveRed() {
        SpeedArrays.isGreenLight = false;
        SpeedArrays.MAX_SPEED = 10;
        int[] speeds = {15, 5, 5, 5, 5, 5, 5, 5, 5};

        int[] expected = {15};
        int[] actual = SpeedArrays.speedLosers(speeds);
        Assertions.assertArrayEquals(expected, actual, "При красном свете метод должен возвращать скорость выбывшего, если выбывший первый");
    }

    @Test
    public void shouldReturnLosersIfLastMoveRed() {
        SpeedArrays.isGreenLight = false;
        SpeedArrays.MAX_SPEED = 10;
        int[] speeds = {5, 5, 5, 5, 5, 5, 5, 5, 17};

        int[] expected = {17};
        int[] actual = SpeedArrays.speedLosers(speeds);
        Assertions.assertArrayEquals(expected, actual, "При красном свете метод должен возвращать скорость выбывшего, если выбывший последний");
    }

    @Test
    public void shouldReturnLosersIfOneMoveRed() {
        SpeedArrays.isGreenLight = false;
        SpeedArrays.MAX_SPEED = 10;
        int[] speeds = {15};

        int[] expected = {15};
        int[] actual = SpeedArrays.speedLosers(speeds);
        Assertions.assertArrayEquals(expected, actual, "При красном свете метод должен возвращать массив из одной скорости, " +
                "если игрок единственный и он выбыл");
    }

    @Test
    public void shouldReturnLosersIfOneStayRed() {
        SpeedArrays.isGreenLight = false;
        SpeedArrays.MAX_SPEED = 10;
        int[] speeds = {5};

        int[] expected = {};
        int[] actual = SpeedArrays.speedLosers(speeds);
        Assertions.assertArrayEquals(expected, actual, "При красном свете метод должен возвращать пустой массив, " +
                "если игрок единственный и он не выбыл");
    }

    @Test
    public void shouldReturnLosersLBStayRed() {
        SpeedArrays.isGreenLight = false;
        SpeedArrays.MAX_SPEED = 10;
        int[] speeds = {15, 15, 15, 0, 15, 15, 15};

        int[] expected = {15, 15, 15, 15, 15, 15};
        int[] actual = SpeedArrays.speedLosers(speeds);
        Assertions.assertArrayEquals(expected, actual, "При красном свете и игроке с нижней границей скорости выигрышего " +
                "метод должен возвращать скорости выбывших");
    }

    @Test
    public void shouldReturnLosersUBStayRed() {
        SpeedArrays.isGreenLight = false;
        SpeedArrays.MAX_SPEED = 10;
        int[] speeds = {15, 15, 15, 10, 15, 15, 15};

        int[] expected = {15, 15, 15, 15, 15, 15};
        int[] actual = SpeedArrays.speedLosers(speeds);
        Assertions.assertArrayEquals(expected, actual, "При красном свете и игроке с верхней границей скорости выигрышего " +
                "метод должен возвращать скорости выбывших");
    }

    @Test
    public void shouldReturnLosersLBMoveRed() {
        SpeedArrays.isGreenLight = false;
        SpeedArrays.MAX_SPEED = 10;
        int[] speeds = {5, 5, 11, 5, 5, 5, 5};

        int[] expected = {11};
        int[] actual = SpeedArrays.speedLosers(speeds);
        Assertions.assertArrayEquals(expected, actual, "При красном свете и игроке с нижней границей скорости выбывшего " +
                "метод должен возвращать скорости выбывших");
    }

    @Test
    public void shouldReturnLosersIfMaxIsZeroRed() {
        SpeedArrays.isGreenLight = false;
        SpeedArrays.MAX_SPEED = 0;
        int[] speeds = {5, 5, 0, 5, 5, 5, 5};

        int[] expected = {5, 5, 5, 5, 5, 5};
        int[] actual = SpeedArrays.speedLosers(speeds);
        Assertions.assertArrayEquals(expected, actual, "При красном свете и MAX = 0 метод должен возвращать скорости выбывших");
    }

    /*
     * speedWinners tests
     */
    @Test
    public void shouldReturnWinnersRed() {
        SpeedArrays.isGreenLight = false;
        SpeedArrays.MAX_SPEED = 10;
        int[] speeds = {15, 16, 5, 5, 17, 5, 18, 19, 20};

        int[] expected = {5, 5, 5};
        int[] actual = SpeedArrays.speedWinners(speeds);
        Assertions.assertArrayEquals(expected, actual, "При красном свете метод должен возвращать скорости выигравших");
    }

    @Test
    public void shouldReturnWinnersIfAllMoveRed() {
        SpeedArrays.isGreenLight = false;
        SpeedArrays.MAX_SPEED = 10;
        int[] speeds = {15, 16, 17, 18, 19, 20, 21, 22, 23};

        int[] expected = {};
        int[] actual = SpeedArrays.speedWinners(speeds);
        Assertions.assertArrayEquals(expected, actual, "При красном свете метод должен возвращать пустой массив скоростей выигравших");
    }

    @Test
    public void shouldReturnWinnersIfAllStayRed() {
        SpeedArrays.isGreenLight = false;
        SpeedArrays.MAX_SPEED = 10;
        int[] speeds = {0, 1, 2, 3, 4, 5, 6, 7, 8};

        int[] expected = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        int[] actual = SpeedArrays.speedWinners(speeds);
        Assertions.assertArrayEquals(expected, actual, "При красном свете метод должен возвращать скорости всех игроков");
    }

    @Test
    public void shouldReturnWinnersIfFirstStayRed() {
        SpeedArrays.isGreenLight = false;
        SpeedArrays.MAX_SPEED = 10;
        int[] speeds = {5, 15, 16, 17, 18, 19, 20, 22, 23};

        int[] expected = {5};
        int[] actual = SpeedArrays.speedWinners(speeds);
        Assertions.assertArrayEquals(expected, actual, "При красном свете метод должен возвращать скорость выигравшего, " +
                "если выигравший первый");
    }

    @Test
    public void shouldReturnWinnersIfLastStayRed() {
        SpeedArrays.isGreenLight = false;
        SpeedArrays.MAX_SPEED = 10;
        int[] speeds = {11, 12, 13, 14, 15, 16, 17, 18, 5};

        int[] expected = {5};
        int[] actual = SpeedArrays.speedWinners(speeds);
        Assertions.assertArrayEquals(expected, actual, "При красном свете метод должен возвращать скорость выигравшего, " +
                "если выигравший последний");
    }

    @Test
    public void shouldReturnWinnersIfOneStayRed() {
        SpeedArrays.isGreenLight = false;
        SpeedArrays.MAX_SPEED = 10;
        int[] speeds = {5};

        int[] expected = {5};
        int[] actual = SpeedArrays.speedWinners(speeds);
        Assertions.assertArrayEquals(expected, actual, "При красном свете метод должен возвращать массив из одной скорости, " +
                "если игрок единственный и он выиграл");
    }

    @Test
    public void shouldReturnWinnersIfOneMoveRed() {
        SpeedArrays.isGreenLight = false;
        SpeedArrays.MAX_SPEED = 10;
        int[] speeds = {15};

        int[] expected = {};
        int[] actual = SpeedArrays.speedWinners(speeds);
        Assertions.assertArrayEquals(expected, actual, "При красном свете метод должен возвращать пустой массив, " +
                "если игрок единственный и он выбыл");
    }


    @Test
    public void shouldReturnWinnersLBStayRed() {
        SpeedArrays.isGreenLight = false;
        SpeedArrays.MAX_SPEED = 10;
        int[] speeds = {15, 0, 15, 0, 15, 15, 15};

        int[] expected = {0, 0};
        int[] actual = SpeedArrays.speedWinners(speeds);
        Assertions.assertArrayEquals(expected, actual, "При красном свете и игроке с нижней границей скорости выигрышего " +
                "метод должен возвращать скорости выигравших");
    }

    @Test
    public void shouldReturnWinnersUBStayRed() {
        SpeedArrays.isGreenLight = false;
        SpeedArrays.MAX_SPEED = 10;
        int[] speeds = {15, 15, 15, 10, 10, 15, 15};

        int[] expected = {10, 10};
        int[] actual = SpeedArrays.speedWinners(speeds);
        Assertions.assertArrayEquals(expected, actual, "При красном свете и игроке с верхней границей скорости выигрышего " +
                "метод должен возвращать скорости выигравших");
    }

    @Test
    public void shouldReturnWinnersLBMoveRed() {
        SpeedArrays.isGreenLight = false;
        SpeedArrays.MAX_SPEED = 10;
        int[] speeds = {5, 5, 11, 5, 5, 5, 5};

        int[] expected = {5, 5, 5, 5, 5, 5};
        int[] actual = SpeedArrays.speedWinners(speeds);
        Assertions.assertArrayEquals(expected, actual, "При красном свете и игроке с нижней границей скорости выбывшего " +
                "метод должен возвращать скорости выигравших");
    }

    @Test
    public void shouldReturnWinnersIfMaxIsZeroRed() {
        SpeedArrays.isGreenLight = false;
        SpeedArrays.MAX_SPEED = 0;
        int[] speeds = {5, 5, 0, 5, 5, 5, 5};

        int[] expected = {0};
        int[] actual = SpeedArrays.speedWinners(speeds);
        Assertions.assertArrayEquals(expected, actual, "При красном свете и MAX = 0 метод должен возвращать скорости выигравших");
    }

    /*
     * If light is green
     * countLoser tests
     */
    @Test
    public void shouldReturnCountOfLosersGreen() {
        SpeedArrays.isGreenLight = true;
        SpeedArrays.MAX_SPEED = 10;
        int[] speeds = {15, 5, 0, 0, 1, 0, 20, 2, 2};

        int expected = 0;
        int actual = SpeedArrays.countLoser(speeds);
        Assertions.assertEquals(expected, actual, "При зеленом свете метод должен возвращать нулевое количество выбывших");
    }

    @Test
    public void shouldReturnCountOfLosersIfAllStayGreen() {
        SpeedArrays.isGreenLight = true;
        SpeedArrays.MAX_SPEED = 10;
        int[] speeds = {5, 5, 5, 5, 5, 5, 5, 5, 5};

        int expected = 0;
        int actual = SpeedArrays.countLoser(speeds);
        Assertions.assertEquals(expected, actual, "При зеленом свете метод должен возвращать нулевое количество выбывших");
    }

    @Test
    public void shouldReturnCountOfLosersIfAllMoveGreen() {
        SpeedArrays.isGreenLight = true;
        SpeedArrays.MAX_SPEED = 10;
        int[] speeds = {15, 15, 11, 13, 11, 14, 20, 12, 12};

        int expected = 0;
        int actual = SpeedArrays.countLoser(speeds);
        Assertions.assertEquals(expected, actual, "При зеленом свете метод должен возвращать нулевое количество выбывших");
    }

    @Test
    public void shouldReturnCountOfLosersIfOneMoveGreen() {
        SpeedArrays.isGreenLight = true;
        SpeedArrays.MAX_SPEED = 10;
        int[] speeds = {11};

        int expected = 0;
        int actual = SpeedArrays.countLoser(speeds);
        Assertions.assertEquals(expected, actual, "При зеленом свете метод должен возвращать нулевое количество выбывших");
    }

    @Test
    public void shouldReturnCountOfLosersIfOneStayGreen() {
        SpeedArrays.isGreenLight = true;
        SpeedArrays.MAX_SPEED = 10;
        int[] speeds = {5};

        int expected = 0;
        int actual = SpeedArrays.countLoser(speeds);
        Assertions.assertEquals(expected, actual, "При зеленом свете метод должен возвращать нулевое количество выбывших");
    }

    @Test
    public void shouldReturnCountOfLosersLBStayGreen() {
        SpeedArrays.isGreenLight = true;
        SpeedArrays.MAX_SPEED = 10;
        int[] speeds = {15, 15, 15, 0, 15, 15, 15};

        int expected = 0;
        int actual = SpeedArrays.countLoser(speeds);
        Assertions.assertEquals(expected, actual, "При зеленом свете и игроке с нижней границей скорости выигрышего " +
                "метод должен возвращать нулевое количество выбывших");
    }

    @Test
    public void shouldReturnCountOfLosersUBStayGreen() {
        SpeedArrays.isGreenLight = true;
        SpeedArrays.MAX_SPEED = 10;
        int[] speeds = {15, 15, 15, 10, 15, 15, 15};

        int expected = 0;
        int actual = SpeedArrays.countLoser(speeds);
        Assertions.assertEquals(expected, actual, "При зеленом свете и игроке с верхней границей скорости выигрышего " +
                "метод должен возвращать нулевое количество выбывших");
    }

    @Test
    public void shouldReturnCountOfLosersLBMoveGreen() {
        SpeedArrays.isGreenLight = true;
        SpeedArrays.MAX_SPEED = 10;
        int[] speeds = {5, 5, 11, 5, 5, 5, 5};

        int expected = 0;
        int actual = SpeedArrays.countLoser(speeds);
        Assertions.assertEquals(expected, actual, "При зеленом свете и игроке с нижней границей скорости выбывшего " +
                "метод должен возвращать нулевое количество выбывших");
    }

    @Test
    public void shouldReturnCountOfLosersIfMaxIsZeroGreen() {
        SpeedArrays.isGreenLight = true;
        SpeedArrays.MAX_SPEED = 0;
        int[] speeds = {5, 5, 0, 5, 5, 5, 5};

        int expected = 0;
        int actual = SpeedArrays.countLoser(speeds);
        Assertions.assertEquals(expected, actual, "При зеленом свете и MAX = 0 метод должен возвращать нулевое количество выбывших");
    }

    /*
     * speedLosers tests
     */
    @Test
    public void shouldReturnLosersGreen() {
        SpeedArrays.isGreenLight = true;
        SpeedArrays.MAX_SPEED = 10;
        int[] speeds = {15, 5, 0, 0, 1, 0, 20, 2, 2};

        int[] expected = {};
        int[] actual = SpeedArrays.speedLosers(speeds);
        Assertions.assertArrayEquals(expected, actual, "При зеленом свете метод должен возвращать пустой массив");
    }

    @Test
    public void shouldReturnLosersIfAllStayGreen() {
        SpeedArrays.isGreenLight = true;
        SpeedArrays.MAX_SPEED = 10;
        int[] speeds = {5, 5, 5, 5, 5, 5, 5, 5, 5};

        int[] expected = {};
        int[] actual = SpeedArrays.speedLosers(speeds);
        Assertions.assertArrayEquals(expected, actual, "При зеленом свете метод должен возвращать пустой массив");
    }

    @Test
    public void shouldReturnLosersIfAllMoveGreen() {
        SpeedArrays.isGreenLight = true;
        SpeedArrays.MAX_SPEED = 10;
        int[] speeds = {15, 15, 11, 13, 11, 14, 20, 12, 12};

        int[] expected = {};
        int[] actual = SpeedArrays.speedLosers(speeds);
        Assertions.assertArrayEquals(expected, actual, "При зеленом свете метод должен возвращать пустой массив");
    }

    @Test
    public void shouldReturnLosersIfOneMoveGreen() {
        SpeedArrays.isGreenLight = true;
        SpeedArrays.MAX_SPEED = 10;
        int[] speeds = {11};

        int[] expected = {};
        int[] actual = SpeedArrays.speedLosers(speeds);
        Assertions.assertArrayEquals(expected, actual, "При зеленом свете метод должен возвращать пустой массив");
    }

    @Test
    public void shouldReturnLosersIfOneStayGreen() {
        SpeedArrays.isGreenLight = true;
        SpeedArrays.MAX_SPEED = 10;
        int[] speeds = {5};

        int[] expected = {};
        int[] actual = SpeedArrays.speedLosers(speeds);
        Assertions.assertArrayEquals(expected, actual, "При зеленом свете метод должен возвращать пустой массив");
    }

    @Test
    public void shouldReturnLosersLBStayGreen() {
        SpeedArrays.isGreenLight = true;
        SpeedArrays.MAX_SPEED = 10;
        int[] speeds = {15, 15, 15, 0, 15, 15, 15};

        int[] expected = {};
        int[] actual = SpeedArrays.speedLosers(speeds);
        Assertions.assertArrayEquals(expected, actual, "При зеленом свете метод должен возвращать пустой массив");
    }

    @Test
    public void shouldReturnLosersUBStayGreen() {
        SpeedArrays.isGreenLight = true;
        SpeedArrays.MAX_SPEED = 10;
        int[] speeds = {15, 15, 15, 10, 15, 15, 15};

        int[] expected = {};
        int[] actual = SpeedArrays.speedLosers(speeds);
        Assertions.assertArrayEquals(expected, actual, "При зеленом свете метод должен возвращать пустой массив");
    }

    @Test
    public void shouldReturnLosersLBMoveGreen() {
        SpeedArrays.isGreenLight = true;
        SpeedArrays.MAX_SPEED = 10;
        int[] speeds = {5, 5, 11, 5, 5, 5, 5};

        int[] expected = {};
        int[] actual = SpeedArrays.speedLosers(speeds);
        Assertions.assertArrayEquals(expected, actual, "При зеленом свете метод должен возвращать пустой массив");
    }

    @Test
    public void shouldReturnLosersIfMaxIsZeroGreen() {
        SpeedArrays.isGreenLight = true;
        SpeedArrays.MAX_SPEED = 0;
        int[] speeds = {5, 5, 0, 5, 5, 5, 5};

        int[] expected = {};
        int[] actual = SpeedArrays.speedLosers(speeds);
        Assertions.assertArrayEquals(expected, actual, "При зеленом свете метод должен возвращать пустой массив");
    }

    /*
     * speedWinners tests
     */
    @Test
    public void shouldReturnWinnersGreen() {
        SpeedArrays.isGreenLight = true;
        SpeedArrays.MAX_SPEED = 10;
        int[] speeds = {15, 5, 0, 0, 1, 0, 20, 2, 2};

        int[] expected = {15, 5, 0, 0, 1, 0, 20, 2, 2};
        int[] actual = SpeedArrays.speedWinners(speeds);
        Assertions.assertArrayEquals(expected, actual, "При зеленом свете метод должен возвращать скорости всех игроков");
    }

    @Test
    public void shouldReturnWinnersIfAllMoveGreen() {
        SpeedArrays.isGreenLight = true;
        SpeedArrays.MAX_SPEED = 10;
        int[] speeds = {15, 15, 11, 13, 11, 14, 20, 12, 12};

        int[] expected = {15, 15, 11, 13, 11, 14, 20, 12, 12};
        int[] actual = SpeedArrays.speedWinners(speeds);
        Assertions.assertArrayEquals(expected, actual, "При зеленом свете метод должен возвращать скорости всех игроков");
    }

    @Test
    public void shouldReturnWinnersIfAllStayGreen() {
        SpeedArrays.isGreenLight = true;
        SpeedArrays.MAX_SPEED = 10;
        int[] speeds = {5, 5, 5, 6, 7, 8, 9, 3, 2};

        int[] expected = {5, 5, 5, 6, 7, 8, 9, 3, 2};
        int[] actual = SpeedArrays.speedWinners(speeds);
        Assertions.assertArrayEquals(expected, actual, "При зеленом свете метод должен возвращать скорости всех игроков");
    }

    @Test
    public void shouldReturnWinnersIfOneStayGreen() {
        SpeedArrays.isGreenLight = true;
        SpeedArrays.MAX_SPEED = 10;
        int[] speeds = {5};

        int[] expected = {5};
        int[] actual = SpeedArrays.speedWinners(speeds);
        Assertions.assertArrayEquals(expected, actual, "При зеленом свете метод должен возвращать скорости всех игроков");
    }

    @Test
    public void shouldReturnWinnersIfOneMoveGreen() {
        SpeedArrays.isGreenLight = true;
        SpeedArrays.MAX_SPEED = 10;
        int[] speeds = {15};

        int[] expected = {15};
        int[] actual = SpeedArrays.speedWinners(speeds);
        Assertions.assertArrayEquals(expected, actual, "При зеленом свете метод должен возвращать скорости всех игроков");
    }


    @Test
    public void shouldReturnWinnersLBStayGreen() {
        SpeedArrays.isGreenLight = true;
        SpeedArrays.MAX_SPEED = 10;
        int[] speeds = {15, 0, 15, 0, 15, 15, 15};

        int[] expected = {15, 0, 15, 0, 15, 15, 15};
        int[] actual = SpeedArrays.speedWinners(speeds);
        Assertions.assertArrayEquals(expected, actual, "При зеленом свете метод должен возвращать скорости всех игроков");
    }

    @Test
    public void shouldReturnWinnersUBStayGreen() {
        SpeedArrays.isGreenLight = true;
        SpeedArrays.MAX_SPEED = 10;
        int[] speeds = {15, 15, 15, 10, 10, 15, 15};

        int[] expected = {15, 15, 15, 10, 10, 15, 15};
        int[] actual = SpeedArrays.speedWinners(speeds);
        Assertions.assertArrayEquals(expected, actual, "При зеленом свете метод должен возвращать скорости всех игроков");
    }

    @Test
    public void shouldReturnWinnersLBMoveGreen() {
        SpeedArrays.isGreenLight = true;
        SpeedArrays.MAX_SPEED = 10;
        int[] speeds = {5, 5, 11, 5, 5, 5, 5};

        int[] expected = {5, 5, 11, 5, 5, 5, 5};
        int[] actual = SpeedArrays.speedWinners(speeds);
        Assertions.assertArrayEquals(expected, actual, "При зеленом свете метод должен возвращать скорости всех игроков");
    }

    @Test
    public void shouldReturnWinnersIfMaxIsZeroGreen() {
        SpeedArrays.isGreenLight = true;
        SpeedArrays.MAX_SPEED = 0;
        int[] speeds = {5, 5, 0, 5, 5, 5, 5};

        int[] expected = {5, 5, 0, 5, 5, 5, 5};
        int[] actual = SpeedArrays.speedWinners(speeds);
        Assertions.assertArrayEquals(expected, actual, "При зеленом свете метод должен возвращать скорости всех игроков");
    }
}
