package game.redgreen;

public class GameManager {
    private final Game game;

    public GameManager(Game game) {
        this.game = game;
    }

    public int roundsWinCount(int[] speeds) {
        if (game.isGreenLight()) {
            return speeds.length;
        }
        int count = 0;
        for (int speed : speeds) {
            if (game.isFailed(speed)) {
                break;
            } else count++;
        }
        return count;
    }

    int loser(Movable p1, Movable p2, Game game, int rounds) {
        if (game.isGreenLight()) {
            return 0;
        }
        for (int i = 0; i < rounds; i++) {
            if (game.isFailed(p1.getSpeed())) {
                return -1;
            }
            if (game.isFailed(p2.getSpeed())) {
                return 1;
            }
        }
        return 0;
    }
}
