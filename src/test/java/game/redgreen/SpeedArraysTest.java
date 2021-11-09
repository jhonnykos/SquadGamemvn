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
        SpeedArrays speedArr = new SpeedArrays(false, 10);
        int[] speeds = {15, 16, 5, 5, 17, 5, 18, 19, 20};

        int expected = 6;
        int actual = speedArr.countLoser(speeds);
        Assertions.assertEquals(expected, actual, "При красном свете метод должен возвращать количество выбывших");
    }

    @Test
    public void shouldReturnCountOfLosersIfAllStayRed() {
        SpeedArrays speedArr = new SpeedArrays(false, 10);
        int[] speeds = {5, 5, 5, 5, 5, 5, 5, 5, 5};

        int expected = 0;
        int actual = speedArr.countLoser(speeds);
        Assertions.assertEquals(expected, actual, "При красном свете метод должен возвращать нулевое количество выбывших");
    }

    @Test
    public void shouldReturnCountOfLosersIfAllMoveRed() {
        SpeedArrays speedArr = new SpeedArrays(false, 10);
        int[] speeds = {15, 16, 17, 18, 19, 20, 21, 22, 23};

        int expected = 9;
        int actual = speedArr.countLoser(speeds);
        Assertions.assertEquals(expected, actual, "При красном свете метод должен возвращать количество всех игроков");
    }

    @Test
    public void shouldReturnCountOfLosersIfFirstMoveRed() {
        SpeedArrays speedArr = new SpeedArrays(false, 10);
        int[] speeds = {15, 5, 5, 5, 5, 5, 5, 5, 5};

        int expected = 1;
        int actual = speedArr.countLoser(speeds);
        Assertions.assertEquals(expected, actual, "При красном свете метод должен возвращать 1, если выбывший первый");
    }

    @Test
    public void shouldReturnCountOfLosersIfLastMoveRed() {
        SpeedArrays speedArr = new SpeedArrays(false, 10);
        int[] speeds = {5, 5, 5, 5, 5, 5, 5, 5, 15};

        int expected = 1;
        int actual = speedArr.countLoser(speeds);
        Assertions.assertEquals(expected, actual, "При красном свете метод должен возвращать 1, если выбывший последний");
    }

    @Test
    public void shouldReturnCountOfLosersIfOneMoveRed() {
        SpeedArrays speedArr = new SpeedArrays(false, 10);
        int[] speeds = {15};

        int expected = 1;
        int actual = speedArr.countLoser(speeds);
        Assertions.assertEquals(expected, actual, "При красном свете метод должен возвращать 1, если игрок единственный и он выбыл");
    }

    @Test
    public void shouldReturnCountOfLosersIfOneStayRed() {
        SpeedArrays speedArr = new SpeedArrays(false, 10);
        int[] speeds = {5};

        int expected = 0;
        int actual = speedArr.countLoser(speeds);
        Assertions.assertEquals(expected, actual, "При красном свете метод должен возвращать 0, если игрок единственный и он не выбыл");
    }

    @Test
    public void shouldReturnCountOfLosersLBStayRed() {
        SpeedArrays speedArr = new SpeedArrays(false, 10);
        int[] speeds = {15, 15, 15, 0, 15, 15, 15};

        int expected = 6;
        int actual = speedArr.countLoser(speeds);
        Assertions.assertEquals(expected, actual, "При красном свете и игроке с нижней границей скорости выигрышего " +
                "метод должен возвращать количество выбывших");
    }

    @Test
    public void shouldReturnCountOfLosersUBStayRed() {
        SpeedArrays speedArr = new SpeedArrays(false, 10);
        int[] speeds = {15, 15, 15, 10, 15, 15, 15};

        int expected = 6;
        int actual = speedArr.countLoser(speeds);
        Assertions.assertEquals(expected, actual, "При красном свете и игроке с верхней границей скорости выигрышего " +
                "метод должен возвращать количество выбывших");
    }

    @Test
    public void shouldReturnCountOfLosersLBMoveRed() {
        SpeedArrays speedArr = new SpeedArrays(false, 10);
        int[] speeds = {5, 5, 11, 5, 5, 5, 5};

        int expected = 1;
        int actual = speedArr.countLoser(speeds);
        Assertions.assertEquals(expected, actual, "При красном свете и игроке с нижней границей скорости выбывшего " +
                "метод должен возвращать количество выбывших");
    }

    @Test
    public void shouldReturnCountOfLosersIfMaxIsZeroRed() {
        SpeedArrays speedArr = new SpeedArrays(false, 0);
        int[] speeds = {5, 5, 0, 5, 5, 5, 5};

        int expected = 6;
        int actual = speedArr.countLoser(speeds);
        Assertions.assertEquals(expected, actual, "При красном свете и MAX = 0 метод должен возвращать количество выбывших");
    }

    /*
     * speedLosers tests
     */
    @Test
    public void shouldReturnLosersRed() {
        SpeedArrays speedArr = new SpeedArrays(false, 10);
        int[] speeds = {15, 16, 5, 5, 5, 5, 11, 20, 5};

        int[] expected = {15, 16, 11, 20};
        int[] actual = speedArr.speedLosers(speeds);
        Assertions.assertArrayEquals(expected, actual, "При красном свете метод должен возвращать скорости выбывших");
    }

    @Test
    public void shouldReturnLosersIfAllStayRed() {
        SpeedArrays speedArr = new SpeedArrays(false, 10);
        int[] speeds = {5, 5, 5, 5, 5, 5, 5, 5, 5};

        int[] expected = {};
        int[] actual = speedArr.speedLosers(speeds);
        Assertions.assertArrayEquals(expected, actual, "При красном свете метод должен возвращать пустой массив скоростей выбывших");
    }

    @Test
    public void shouldReturnLosersIfAllMoveRed() {
        SpeedArrays speedArr = new SpeedArrays(false, 10);
        int[] speeds = {15, 16, 17, 18, 19, 20, 21, 22, 23};

        int[] expected = {15, 16, 17, 18, 19, 20, 21, 22, 23};
        int[] actual = speedArr.speedLosers(speeds);
        Assertions.assertArrayEquals(expected, actual, "При красном свете метод должен возвращать скорости всех игроков");
    }

    @Test
    public void shouldReturnLosersIfFirstMoveRed() {
        SpeedArrays speedArr = new SpeedArrays(false, 10);
        int[] speeds = {15, 5, 5, 5, 5, 5, 5, 5, 5};

        int[] expected = {15};
        int[] actual = speedArr.speedLosers(speeds);
        Assertions.assertArrayEquals(expected, actual, "При красном свете метод должен возвращать скорость выбывшего, если выбывший первый");
    }

    @Test
    public void shouldReturnLosersIfLastMoveRed() {
        SpeedArrays speedArr = new SpeedArrays(false, 10);
        int[] speeds = {5, 5, 5, 5, 5, 5, 5, 5, 17};

        int[] expected = {17};
        int[] actual = speedArr.speedLosers(speeds);
        Assertions.assertArrayEquals(expected, actual, "При красном свете метод должен возвращать скорость выбывшего, если выбывший последний");
    }

    @Test
    public void shouldReturnLosersIfOneMoveRed() {
        SpeedArrays speedArr = new SpeedArrays(false, 10);
        int[] speeds = {15};

        int[] expected = {15};
        int[] actual = speedArr.speedLosers(speeds);
        Assertions.assertArrayEquals(expected, actual, "При красном свете метод должен возвращать массив из одной скорости, " +
                "если игрок единственный и он выбыл");
    }

    @Test
    public void shouldReturnLosersIfOneStayRed() {
        SpeedArrays speedArr = new SpeedArrays(false, 10);
        int[] speeds = {5};

        int[] expected = {};
        int[] actual = speedArr.speedLosers(speeds);
        Assertions.assertArrayEquals(expected, actual, "При красном свете метод должен возвращать пустой массив, " +
                "если игрок единственный и он не выбыл");
    }

    @Test
    public void shouldReturnLosersLBStayRed() {
        SpeedArrays speedArr = new SpeedArrays(false, 10);
        int[] speeds = {15, 15, 15, 0, 15, 15, 15};

        int[] expected = {15, 15, 15, 15, 15, 15};
        int[] actual = speedArr.speedLosers(speeds);
        Assertions.assertArrayEquals(expected, actual, "При красном свете и игроке с нижней границей скорости выигрышего " +
                "метод должен возвращать скорости выбывших");
    }

    @Test
    public void shouldReturnLosersUBStayRed() {
        SpeedArrays speedArr = new SpeedArrays(false, 10);
        int[] speeds = {15, 15, 15, 10, 15, 15, 15};

        int[] expected = {15, 15, 15, 15, 15, 15};
        int[] actual = speedArr.speedLosers(speeds);
        Assertions.assertArrayEquals(expected, actual, "При красном свете и игроке с верхней границей скорости выигрышего " +
                "метод должен возвращать скорости выбывших");
    }

    @Test
    public void shouldReturnLosersLBMoveRed() {
        SpeedArrays speedArr = new SpeedArrays(false, 10);
        int[] speeds = {5, 5, 11, 5, 5, 5, 5};

        int[] expected = {11};
        int[] actual = speedArr.speedLosers(speeds);
        Assertions.assertArrayEquals(expected, actual, "При красном свете и игроке с нижней границей скорости выбывшего " +
                "метод должен возвращать скорости выбывших");
    }

    @Test
    public void shouldReturnLosersIfMaxIsZeroRed() {
        SpeedArrays speedArr = new SpeedArrays(false, 0);
        int[] speeds = {5, 5, 0, 5, 5, 5, 5};

        int[] expected = {5, 5, 5, 5, 5, 5};
        int[] actual = speedArr.speedLosers(speeds);
        Assertions.assertArrayEquals(expected, actual, "При красном свете и MAX = 0 метод должен возвращать скорости выбывших");
    }

    /*
     * speedWinners tests
     */
    @Test
    public void shouldReturnWinnersRed() {
        SpeedArrays speedArr = new SpeedArrays(false, 10);
        int[] speeds = {15, 16, 5, 5, 17, 5, 18, 19, 20};

        int[] expected = {5, 5, 5};
        int[] actual = speedArr.speedWinners(speeds);
        Assertions.assertArrayEquals(expected, actual, "При красном свете метод должен возвращать скорости выигравших");
    }

    @Test
    public void shouldReturnWinnersIfAllMoveRed() {
        SpeedArrays speedArr = new SpeedArrays(false, 10);
        int[] speeds = {15, 16, 17, 18, 19, 20, 21, 22, 23};

        int[] expected = {};
        int[] actual = speedArr.speedWinners(speeds);
        Assertions.assertArrayEquals(expected, actual, "При красном свете метод должен возвращать пустой массив скоростей выигравших");
    }

    @Test
    public void shouldReturnWinnersIfAllStayRed() {
        SpeedArrays speedArr = new SpeedArrays(false, 10);
        int[] speeds = {0, 1, 2, 3, 4, 5, 6, 7, 8};

        int[] expected = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        int[] actual = speedArr.speedWinners(speeds);
        Assertions.assertArrayEquals(expected, actual, "При красном свете метод должен возвращать скорости всех игроков");
    }

    @Test
    public void shouldReturnWinnersIfFirstStayRed() {
        SpeedArrays speedArr = new SpeedArrays(false, 10);
        int[] speeds = {5, 15, 16, 17, 18, 19, 20, 22, 23};

        int[] expected = {5};
        int[] actual = speedArr.speedWinners(speeds);
        Assertions.assertArrayEquals(expected, actual, "При красном свете метод должен возвращать скорость выигравшего, " +
                "если выигравший первый");
    }

    @Test
    public void shouldReturnWinnersIfLastStayRed() {
        SpeedArrays speedArr = new SpeedArrays(false, 10);
        int[] speeds = {11, 12, 13, 14, 15, 16, 17, 18, 5};

        int[] expected = {5};
        int[] actual = speedArr.speedWinners(speeds);
        Assertions.assertArrayEquals(expected, actual, "При красном свете метод должен возвращать скорость выигравшего, " +
                "если выигравший последний");
    }

    @Test
    public void shouldReturnWinnersIfOneStayRed() {
        SpeedArrays speedArr = new SpeedArrays(false, 10);
        int[] speeds = {5};

        int[] expected = {5};
        int[] actual = speedArr.speedWinners(speeds);
        Assertions.assertArrayEquals(expected, actual, "При красном свете метод должен возвращать массив из одной скорости, " +
                "если игрок единственный и он выиграл");
    }

    @Test
    public void shouldReturnWinnersIfOneMoveRed() {
        SpeedArrays speedArr = new SpeedArrays(false, 10);
        int[] speeds = {15};

        int[] expected = {};
        int[] actual = speedArr.speedWinners(speeds);
        Assertions.assertArrayEquals(expected, actual, "При красном свете метод должен возвращать пустой массив, " +
                "если игрок единственный и он выбыл");
    }


    @Test
    public void shouldReturnWinnersLBStayRed() {
        SpeedArrays speedArr = new SpeedArrays(false, 10);
        int[] speeds = {15, 0, 15, 0, 15, 15, 15};

        int[] expected = {0, 0};
        int[] actual = speedArr.speedWinners(speeds);
        Assertions.assertArrayEquals(expected, actual, "При красном свете и игроке с нижней границей скорости выигрышего " +
                "метод должен возвращать скорости выигравших");
    }

    @Test
    public void shouldReturnWinnersUBStayRed() {
        SpeedArrays speedArr = new SpeedArrays(false, 10);
        int[] speeds = {15, 15, 15, 10, 10, 15, 15};

        int[] expected = {10, 10};
        int[] actual = speedArr.speedWinners(speeds);
        Assertions.assertArrayEquals(expected, actual, "При красном свете и игроке с верхней границей скорости выигрышего " +
                "метод должен возвращать скорости выигравших");
    }

    @Test
    public void shouldReturnWinnersLBMoveRed() {
        SpeedArrays speedArr = new SpeedArrays(false, 10);
        int[] speeds = {5, 5, 11, 5, 5, 5, 5};

        int[] expected = {5, 5, 5, 5, 5, 5};
        int[] actual = speedArr.speedWinners(speeds);
        Assertions.assertArrayEquals(expected, actual, "При красном свете и игроке с нижней границей скорости выбывшего " +
                "метод должен возвращать скорости выигравших");
    }

    @Test
    public void shouldReturnWinnersIfMaxIsZeroRed() {
        SpeedArrays speedArr = new SpeedArrays(false, 0);
        int[] speeds = {5, 5, 0, 5, 5, 5, 5};

        int[] expected = {0};
        int[] actual = speedArr.speedWinners(speeds);
        Assertions.assertArrayEquals(expected, actual, "При красном свете и MAX = 0 метод должен возвращать скорости выигравших");
    }

    /*
     * If light is green
     * countLoser tests
     */
    @Test
    public void shouldReturnCountOfLosersGreen() {
        SpeedArrays speedArr = new SpeedArrays(true, 10);
        int[] speeds = {15, 5, 0, 0, 1, 0, 20, 2, 2};

        int expected = 0;
        int actual = speedArr.countLoser(speeds);
        Assertions.assertEquals(expected, actual, "При зеленом свете метод должен возвращать нулевое количество выбывших");
    }

    @Test
    public void shouldReturnCountOfLosersIfAllStayGreen() {
        SpeedArrays speedArr = new SpeedArrays(true, 10);
        int[] speeds = {5, 5, 5, 5, 5, 5, 5, 5, 5};

        int expected = 0;
        int actual = speedArr.countLoser(speeds);
        Assertions.assertEquals(expected, actual, "При зеленом свете метод должен возвращать нулевое количество выбывших");
    }

    @Test
    public void shouldReturnCountOfLosersIfAllMoveGreen() {
        SpeedArrays speedArr = new SpeedArrays(true, 10);
        int[] speeds = {15, 15, 11, 13, 11, 14, 20, 12, 12};

        int expected = 0;
        int actual = speedArr.countLoser(speeds);
        Assertions.assertEquals(expected, actual, "При зеленом свете метод должен возвращать нулевое количество выбывших");
    }

    @Test
    public void shouldReturnCountOfLosersIfOneMoveGreen() {
        SpeedArrays speedArr = new SpeedArrays(true, 10);
        int[] speeds = {11};

        int expected = 0;
        int actual = speedArr.countLoser(speeds);
        Assertions.assertEquals(expected, actual, "При зеленом свете метод должен возвращать нулевое количество выбывших");
    }

    @Test
    public void shouldReturnCountOfLosersIfOneStayGreen() {
        SpeedArrays speedArr = new SpeedArrays(true, 10);
        int[] speeds = {5};

        int expected = 0;
        int actual = speedArr.countLoser(speeds);
        Assertions.assertEquals(expected, actual, "При зеленом свете метод должен возвращать нулевое количество выбывших");
    }

    @Test
    public void shouldReturnCountOfLosersLBStayGreen() {
        SpeedArrays speedArr = new SpeedArrays(true, 10);
        int[] speeds = {15, 15, 15, 0, 15, 15, 15};

        int expected = 0;
        int actual = speedArr.countLoser(speeds);
        Assertions.assertEquals(expected, actual, "При зеленом свете и игроке с нижней границей скорости выигрышего " +
                "метод должен возвращать нулевое количество выбывших");
    }

    @Test
    public void shouldReturnCountOfLosersUBStayGreen() {
        SpeedArrays speedArr = new SpeedArrays(true, 10);
        int[] speeds = {15, 15, 15, 10, 15, 15, 15};

        int expected = 0;
        int actual = speedArr.countLoser(speeds);
        Assertions.assertEquals(expected, actual, "При зеленом свете и игроке с верхней границей скорости выигрышего " +
                "метод должен возвращать нулевое количество выбывших");
    }

    @Test
    public void shouldReturnCountOfLosersLBMoveGreen() {
        SpeedArrays speedArr = new SpeedArrays(true, 10);
        int[] speeds = {5, 5, 11, 5, 5, 5, 5};

        int expected = 0;
        int actual = speedArr.countLoser(speeds);
        Assertions.assertEquals(expected, actual, "При зеленом свете и игроке с нижней границей скорости выбывшего " +
                "метод должен возвращать нулевое количество выбывших");
    }

    @Test
    public void shouldReturnCountOfLosersIfMaxIsZeroGreen() {
        SpeedArrays speedArr = new SpeedArrays(true, 10);
        int[] speeds = {5, 5, 0, 5, 5, 5, 5};

        int expected = 0;
        int actual = speedArr.countLoser(speeds);
        Assertions.assertEquals(expected, actual, "При зеленом свете и MAX = 0 метод должен возвращать нулевое количество выбывших");
    }

    /*
     * speedLosers tests
     */
    @Test
    public void shouldReturnLosersGreen() {
        SpeedArrays speedArr = new SpeedArrays(true, 10);
        int[] speeds = {15, 5, 0, 0, 1, 0, 20, 2, 2};

        int[] expected = {};
        int[] actual = speedArr.speedLosers(speeds);
        Assertions.assertArrayEquals(expected, actual, "При зеленом свете метод должен возвращать пустой массив");
    }

    @Test
    public void shouldReturnLosersIfAllStayGreen() {
        SpeedArrays speedArr = new SpeedArrays(true, 10);
        int[] speeds = {5, 5, 5, 5, 5, 5, 5, 5, 5};

        int[] expected = {};
        int[] actual = speedArr.speedLosers(speeds);
        Assertions.assertArrayEquals(expected, actual, "При зеленом свете метод должен возвращать пустой массив");
    }

    @Test
    public void shouldReturnLosersIfAllMoveGreen() {
        SpeedArrays speedArr = new SpeedArrays(true, 10);
        int[] speeds = {15, 15, 11, 13, 11, 14, 20, 12, 12};

        int[] expected = {};
        int[] actual = speedArr.speedLosers(speeds);
        Assertions.assertArrayEquals(expected, actual, "При зеленом свете метод должен возвращать пустой массив");
    }

    @Test
    public void shouldReturnLosersIfOneMoveGreen() {
        SpeedArrays speedArr = new SpeedArrays(true, 10);
        int[] speeds = {11};

        int[] expected = {};
        int[] actual = speedArr.speedLosers(speeds);
        Assertions.assertArrayEquals(expected, actual, "При зеленом свете метод должен возвращать пустой массив");
    }

    @Test
    public void shouldReturnLosersIfOneStayGreen() {
        SpeedArrays speedArr = new SpeedArrays(true, 10);
        int[] speeds = {5};

        int[] expected = {};
        int[] actual = speedArr.speedLosers(speeds);
        Assertions.assertArrayEquals(expected, actual, "При зеленом свете метод должен возвращать пустой массив");
    }

    @Test
    public void shouldReturnLosersLBStayGreen() {
        SpeedArrays speedArr = new SpeedArrays(true, 10);
        int[] speeds = {15, 15, 15, 0, 15, 15, 15};

        int[] expected = {};
        int[] actual = speedArr.speedLosers(speeds);
        Assertions.assertArrayEquals(expected, actual, "При зеленом свете метод должен возвращать пустой массив");
    }

    @Test
    public void shouldReturnLosersUBStayGreen() {
        SpeedArrays speedArr = new SpeedArrays(true, 10);
        int[] speeds = {15, 15, 15, 10, 15, 15, 15};

        int[] expected = {};
        int[] actual = speedArr.speedLosers(speeds);
        Assertions.assertArrayEquals(expected, actual, "При зеленом свете метод должен возвращать пустой массив");
    }

    @Test
    public void shouldReturnLosersLBMoveGreen() {
        SpeedArrays speedArr = new SpeedArrays(true, 10);
        int[] speeds = {5, 5, 11, 5, 5, 5, 5};

        int[] expected = {};
        int[] actual = speedArr.speedLosers(speeds);
        Assertions.assertArrayEquals(expected, actual, "При зеленом свете метод должен возвращать пустой массив");
    }

    @Test
    public void shouldReturnLosersIfMaxIsZeroGreen() {
        SpeedArrays speedArr = new SpeedArrays(true, 0);
        int[] speeds = {5, 5, 0, 5, 5, 5, 5};

        int[] expected = {};
        int[] actual = speedArr.speedLosers(speeds);
        Assertions.assertArrayEquals(expected, actual, "При зеленом свете метод должен возвращать пустой массив");
    }

    /*
     * speedWinners tests
     */
    @Test
    public void shouldReturnWinnersGreen() {
        SpeedArrays speedArr = new SpeedArrays(true, 10);
        int[] speeds = {15, 5, 0, 0, 1, 0, 20, 2, 2};

        int[] expected = {15, 5, 0, 0, 1, 0, 20, 2, 2};
        int[] actual = speedArr.speedWinners(speeds);
        Assertions.assertArrayEquals(expected, actual, "При зеленом свете метод должен возвращать скорости всех игроков");
    }

    @Test
    public void shouldReturnWinnersIfAllMoveGreen() {
        SpeedArrays speedArr = new SpeedArrays(true, 10);
        int[] speeds = {15, 15, 11, 13, 11, 14, 20, 12, 12};

        int[] expected = {15, 15, 11, 13, 11, 14, 20, 12, 12};
        int[] actual = speedArr.speedWinners(speeds);
        Assertions.assertArrayEquals(expected, actual, "При зеленом свете метод должен возвращать скорости всех игроков");
    }

    @Test
    public void shouldReturnWinnersIfAllStayGreen() {
        SpeedArrays speedArr = new SpeedArrays(true, 10);
        int[] speeds = {5, 5, 5, 6, 7, 8, 9, 3, 2};

        int[] expected = {5, 5, 5, 6, 7, 8, 9, 3, 2};
        int[] actual = speedArr.speedWinners(speeds);
        Assertions.assertArrayEquals(expected, actual, "При зеленом свете метод должен возвращать скорости всех игроков");
    }

    @Test
    public void shouldReturnWinnersIfOneStayGreen() {
        SpeedArrays speedArr = new SpeedArrays(true, 10);
        int[] speeds = {5};

        int[] expected = {5};
        int[] actual = speedArr.speedWinners(speeds);
        Assertions.assertArrayEquals(expected, actual, "При зеленом свете метод должен возвращать скорости всех игроков");
    }

    @Test
    public void shouldReturnWinnersIfOneMoveGreen() {
        SpeedArrays speedArr = new SpeedArrays(true, 10);
        int[] speeds = {15};

        int[] expected = {15};
        int[] actual = speedArr.speedWinners(speeds);
        Assertions.assertArrayEquals(expected, actual, "При зеленом свете метод должен возвращать скорости всех игроков");
    }

    @Test
    public void shouldReturnWinnersLBStayGreen() {
        SpeedArrays speedArr = new SpeedArrays(true, 10);
        int[] speeds = {15, 0, 15, 0, 15, 15, 15};

        int[] expected = {15, 0, 15, 0, 15, 15, 15};
        int[] actual = speedArr.speedWinners(speeds);
        Assertions.assertArrayEquals(expected, actual, "При зеленом свете метод должен возвращать скорости всех игроков");
    }

    @Test
    public void shouldReturnWinnersUBStayGreen() {
        SpeedArrays speedArr = new SpeedArrays(true, 10);
        int[] speeds = {15, 15, 15, 10, 10, 15, 15};

        int[] expected = {15, 15, 15, 10, 10, 15, 15};
        int[] actual = speedArr.speedWinners(speeds);
        Assertions.assertArrayEquals(expected, actual, "При зеленом свете метод должен возвращать скорости всех игроков");
    }

    @Test
    public void shouldReturnWinnersLBMoveGreen() {
        SpeedArrays speedArr = new SpeedArrays(true, 10);
        int[] speeds = {5, 5, 11, 5, 5, 5, 5};

        int[] expected = {5, 5, 11, 5, 5, 5, 5};
        int[] actual = speedArr.speedWinners(speeds);
        Assertions.assertArrayEquals(expected, actual, "При зеленом свете метод должен возвращать скорости всех игроков");
    }

    @Test
    public void shouldReturnWinnersIfMaxIsZeroGreen() {
        SpeedArrays speedArr = new SpeedArrays(true, 0);
        int[] speeds = {5, 5, 0, 5, 5, 5, 5};

        int[] expected = {5, 5, 0, 5, 5, 5, 5};
        int[] actual = speedArr.speedWinners(speeds);
        Assertions.assertArrayEquals(expected, actual, "При зеленом свете метод должен возвращать скорости всех игроков");
    }

    /*
     * If light is red
     * nameWinners tests
     */
    @Test
    public void shouldReturnNamesWinnersRed() {
        SpeedArrays speedArr = new SpeedArrays(false, 10);
        String[] players = {"Olya 10", "Pavel 5", "Grisha 15", "Vasya 9", "Nastya 0", "Anya 20"};

        String[] expected = {"Olya", "Pavel", "Vasya", "Nastya"};
        String[] actual = speedArr.nameWinners(players);
        Assertions.assertArrayEquals(expected, actual, "Метод должен возвращать имена выигравших");
    }

    @Test
    public void shouldReturnNamesWinnersIfAllMoveRed() {
        SpeedArrays speedArr = new SpeedArrays(false, 10);
        String[] players = {"Olya 15", "Pavel 25", "Grisha 15", "Vasya 19", "Nastya 11", "Anya 20"};

        String[] expected = {};
        String[] actual = speedArr.nameWinners(players);
        Assertions.assertArrayEquals(expected, actual, "При красном свете метод должен возвращать пустой массив имен выигравших");
    }

    @Test
    public void shouldReturnNamesWinnersIfAllStayRed() {
        SpeedArrays speedArr = new SpeedArrays(false, 10);
        String[] players = {"Olya 5", "Pavel 0", "Grisha 1", "Vasya 9", "Nastya 9", "Anya 2"};

        String[] expected = {"Olya", "Pavel", "Grisha", "Vasya", "Nastya", "Anya"};
        String[] actual = speedArr.nameWinners(players);
        Assertions.assertArrayEquals(expected, actual, "При красном свете метод должен возвращать имена всех игроков");
    }

    @Test
    public void shouldReturnNamesWinnersIfFirstStayRed() {
        SpeedArrays speedArr = new SpeedArrays(false, 10);
        String[] players = {"Olya 5", "Pavel 15", "Grisha 15", "Vasya 19", "Nastya 19", "Anya 11"};

        String[] expected = {"Olya"};
        String[] actual = speedArr.nameWinners(players);
        Assertions.assertArrayEquals(expected, actual, "При красном свете метод должен возвращать имя выигравшего, " +
                "если выигравший первый");
    }

    @Test
    public void shouldReturnNamesWinnersIfLastStayRed() {
        SpeedArrays speedArr = new SpeedArrays(false, 10);
        String[] players = {"Olya 15", "Pavel 11", "Grisha 11", "Vasya 19", "Nastya 19", "Anya 2"};

        String[] expected = {"Anya"};
        String[] actual = speedArr.nameWinners(players);
        Assertions.assertArrayEquals(expected, actual, "При красном свете метод должен возвращать имя выигравшего, " +
                "если выигравший последний");
    }

    @Test
    public void shouldReturnNamesWinnersIfOneStayRed() {
        SpeedArrays speedArr = new SpeedArrays(false, 10);
        String[] players = {"Olya 5"};

        String[] expected = {"Olya"};
        String[] actual = speedArr.nameWinners(players);
        Assertions.assertArrayEquals(expected, actual, "При красном свете метод должен возвращать массив из одного имени, " +
                "если игрок единственный и он выиграл");
    }

    @Test
    public void shouldReturnNamesWinnersIfOneMoveRed() {
        SpeedArrays speedArr = new SpeedArrays(false, 10);
        String[] players = {"Olya 15"};

        String[] expected = {};
        String[] actual = speedArr.nameWinners(players);
        Assertions.assertArrayEquals(expected, actual, "При красном свете метод должен возвращать пустой массив, " +
                "если игрок единственный и он выбыл");
    }

    @Test
    public void shouldReturnNamesWinnersIfEmptyRed() {
        SpeedArrays speedArr = new SpeedArrays(false, 10);
        String[] players = {};

        String[] expected = {};
        String[] actual = speedArr.nameWinners(players);
        Assertions.assertArrayEquals(expected, actual, "Метод должен возвращать пустой массив");
    }

    /*
     * If light is green
     * nameWinners tests
     */
    @Test
    public void shouldReturnNamesWinnersGreen() {
        SpeedArrays speedArr = new SpeedArrays(true, 10);
        String[] players = {"Olya 10", "Pavel 5", "Grisha 15", "Vasya 9", "Nastya 0", "Anya 20"};

        String[] expected = {"Olya", "Pavel", "Grisha", "Vasya", "Nastya", "Anya"};
        String[] actual = speedArr.nameWinners(players);
        Assertions.assertArrayEquals(expected, actual, "Метод должен возвращать имена всех игроков");
    }

    @Test
    public void shouldReturnNamesWinnersIfAllMoveGreen() {
        SpeedArrays speedArr = new SpeedArrays(true, 10);
        String[] players = {"Olya 15", "Pavel 15", "Grisha 15", "Vasya 19", "Nastya 20", "Anya 11"};

        String[] expected = {"Olya", "Pavel", "Grisha", "Vasya", "Nastya", "Anya"};
        String[] actual = speedArr.nameWinners(players);
        Assertions.assertArrayEquals(expected, actual, "Метод должен возвращать имена всех игроков");
    }

    @Test
    public void shouldReturnNamesWinnersIfAllStayGreen() {
        SpeedArrays speedArr = new SpeedArrays(false, 10);
        String[] players = {"Olya 1", "Pavel 0", "Grisha 5", "Vasya 9", "Nastya 0", "Anya 10"};

        String[] expected = {"Olya", "Pavel", "Grisha", "Vasya", "Nastya", "Anya"};
        String[] actual = speedArr.nameWinners(players);
        Assertions.assertArrayEquals(expected, actual, "Метод должен возвращать имена всех игроков");
    }

    @Test
    public void shouldReturnNamesWinnersIfOneStayGreen() {
        SpeedArrays speedArr = new SpeedArrays(false, 10);
        String[] players = {"Olya 7"};

        String[] expected = {"Olya"};
        String[] actual = speedArr.nameWinners(players);
        Assertions.assertArrayEquals(expected, actual, "Метод должен возвращать имена всех игроков");
    }

    @Test
    public void shouldReturnNamesWinnersIfOneMoveGreen() {
        SpeedArrays speedArr = new SpeedArrays(true, 10);
        String[] players = {"Olya 17"};

        String[] expected = {"Olya"};
        String[] actual = speedArr.nameWinners(players);
        Assertions.assertArrayEquals(expected, actual, "Метод должен возвращать имена всех игроков");
    }

    @Test
    public void shouldReturnNamesWinnersIfEmptyGreen() {
        SpeedArrays speedArr = new SpeedArrays(true, 10);
        String[] players = {};

        String[] expected = {};
        String[] actual = speedArr.nameWinners(players);
        Assertions.assertArrayEquals(expected, actual, "Метод должен возвращать пустой массив");
    }
}
