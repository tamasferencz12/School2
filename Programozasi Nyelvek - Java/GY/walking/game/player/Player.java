package walking.game.player;
import walking.game.util.Direction;

public class Player {
    
    private int score;

    protected Direction direction = Direction.UP;

    public int getScore(){
        return this.score;
    }

    public void setScore(int score){
        this.score = score;
    }

    public Direction getDirection(){
        return this.direction;
    }

    public void setDirection(Direction direction){
        this.direction = direction;
    }

    public void addToScore(int score){
        int something;
    }

    public void turn(){
        int something;
    }
}
