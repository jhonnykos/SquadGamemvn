package game.redgreen;

public class FastPlayer implements Movable{
    private int startSpeed;
    private int speedStep;

    public FastPlayer(int startSpeed, int speedStep){
        this.speedStep = speedStep;
        this.startSpeed = startSpeed;
    }

    @Override
    public int getSpeed() {
        int curSpeed = startSpeed;
        startSpeed += speedStep;
        return curSpeed;
    }
}
