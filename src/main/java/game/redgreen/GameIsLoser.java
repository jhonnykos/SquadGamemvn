package game.redgreen;

public class GameIsLoser {

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
