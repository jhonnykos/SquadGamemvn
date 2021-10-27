package game.redgreen;

public class SpeedArrays {

    public static int countLoser(int[] speedOfPlayers) {
        int count = 0;
        for (int speed : speedOfPlayers) {
            if (speed != 0) {
                count++;
            }
        }

        return count;
    }


    public static int[] speedLosers(int[] speedOfPlayers) {
        int count = 0;
        for (int speed : speedOfPlayers) {
            if (speed != 0) {
                count++;
            }
        }

        int[] speedOfLosers = new int[count];

        for (int i = 0, j = 0; i < speedOfPlayers.length; i++) {
            int speed = speedOfPlayers[i];
            if (speed != 0) {
                speedOfLosers[j++] = speed;
            }
        }

        return speedOfLosers;
    }


    public static int[] speedWinners(int[] speedOfPlayers) {
        int count = 0;
        for (int speed : speedOfPlayers) {
            if (speed == 0) {
                count++;
            }
        }

        int[] speedOfWinners = new int[count];

        for (int i = 0, j = 0; i < speedOfPlayers.length; i++) {
            int speed = speedOfPlayers[i];
            if (speed == 0) {
                speedOfWinners[j++] = speed;
            }
        }

        return speedOfWinners;
    }
}
