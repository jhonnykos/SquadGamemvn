import game.redgreen.SpeedArrays;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int speedOfPlayer1 = 5;
        int speedOfPlayer2 = 0;
        int speedOfPlayer3 = 2;

        int loserCount = 0;

//        if (isLoser(speedOfPlayer1)) {
//            loserCount++;
//        }
//        if (isLoser(speedOfPlayer2)) {
//            loserCount++;
//        }
//        if (isLoser(speedOfPlayer3)) {
//            loserCount++;
//        }

        System.out.println("Всего выбыло " + loserCount + " игроков");
        SpeedArrays speedArr = new SpeedArrays(false,10);
        int[] speeds = {15, 5, 0, 3, 0};

        loserCount = speedArr.countLoser(speeds);
        int[] speedLosers = speedArr.speedLosers(speeds);
        int[] speedWinners = speedArr.speedWinners(speeds);

        System.out.println("Среди " + speeds.length + " игроков: \n" +
                "Выбыло " + loserCount + " игроков, осталось " + (speeds.length - loserCount) + " игроков \n" +
                "Скорости выбывших: " + Arrays.toString(speedLosers) + "\n" +
                "Скорости оставшихся: " + Arrays.toString(speedWinners)
        );
    }
}
