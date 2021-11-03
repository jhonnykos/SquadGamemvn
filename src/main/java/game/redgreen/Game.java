package game.redgreen;

import lombok.Data;

@Data
public class Game {
    private boolean isGreenLight;

    public Game(boolean isGreenLight) {
        this.isGreenLight = isGreenLight;
    }

    boolean isFailed(int speed) {
        return !isGreenLight && speed != 0;
    }

}
