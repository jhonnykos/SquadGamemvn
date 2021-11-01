package game.redgreen;

public class SpeedArrays {

    public boolean isGreenLight;
    public int MAX_SPEED;

    public SpeedArrays(boolean isGreenLight, int maxSpeed){
        this.isGreenLight = isGreenLight;
        this.MAX_SPEED = maxSpeed;
    }

    public int countLoser(int[] speedOfPlayers) {
        int count = 0;

        if (!isGreenLight) {
            for (int speed : speedOfPlayers) {
                if (speed > MAX_SPEED) {
                    count++;
                }
            }
        }

        return count;
    }


    public int[] speedLosers(int[] speedOfPlayers) {
        if (isGreenLight) return new int[0];

        int count = countLoser(speedOfPlayers);
        int[] speedOfLosers = new int[count];

        if (count != 0) {
            for (int i = 0, j = 0; i < speedOfPlayers.length; i++) {
                int speed = speedOfPlayers[i];
                if (speed > MAX_SPEED) {
                    speedOfLosers[j++] = speed;
                }
            }
        }

        return speedOfLosers;
    }


    public int[] speedWinners(int[] speedOfPlayers) {
        if (isGreenLight) return speedOfPlayers;

        int count = speedOfPlayers.length - countLoser(speedOfPlayers);
        int[] speedOfWinners = new int[count];

        if (count != 0) {
            for (int i = 0, j = 0; i < speedOfPlayers.length; i++) {
                int speed = speedOfPlayers[i];
                if (speed <= MAX_SPEED) {
                    speedOfWinners[j++] = speed;
                }
            }
        }

        return speedOfWinners;
    }

    public String[] nameWinners(String[] playersInfo) {
        String playersNames = "";

        for (String player : playersInfo) {
            String[] info = player.split(" ");
            if (isGreenLight) {
                playersNames += info[0] + " ";
                continue;
            }
            int speed = Integer.parseInt(info[1]);
            if (speed <= MAX_SPEED) {
                playersNames += info[0] + " ";
            }
        }

        if (playersNames.isEmpty()) return new String[0];

        String[] names = playersNames.split(" ");
        return names;
    }
}
