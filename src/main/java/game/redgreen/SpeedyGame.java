package game.redgreen;

public class SpeedyGame extends Game {
    private int maxSpeed;

    public SpeedyGame(boolean isGreenLight, int maxSpeed) {
        super(isGreenLight);
        this.maxSpeed = maxSpeed;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    boolean isFailed(int speed) {
        return !super.isGreenLight() && speed > maxSpeed;
    }
}
