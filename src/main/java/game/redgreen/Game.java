package game.redgreen;

public class Game {

    static boolean isGreenLight = false;

    public static boolean isLoser(int speedOfPlayer) {
        if (!isGreenLight) {
            if (speedOfPlayer != 0) {
                return true;
            }
        }
        return false;
    }
}
