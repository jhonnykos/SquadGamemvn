package game.redgreen;

public class ConstantPlayer implements Movable{
    private int speed;

    public ConstantPlayer(int speed){
        this.speed = speed;
    }

    @Override
    public int getSpeed(){
        return speed;
    }
}
