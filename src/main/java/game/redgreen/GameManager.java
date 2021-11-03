package game.redgreen;

public class GameManager {
    private final Game game;

    public GameManager(Game game) {
        this.game = game;
    }

    public int roundsWinCount(int[] speeds) {
        if (game.isGreenLight()) return speeds.length;
        int count = 0;
        for (int speed : speeds) {
            if (game.isFailed(speed)) break;
            else count++;
        }
        return count;
    }
}
