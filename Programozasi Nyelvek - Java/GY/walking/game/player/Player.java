package walking.game.player;

import walking.game.util.Direction;

public class Player {

    private int score;

    protected Direction direction = Direction.UP;

    public Player() {

    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void addToScore(int score) {
        this.score += score;
    }

    public void turn() {
        switch (getDirection()) {
            case Direction.UP:
                setDirection(Direction.RIGHT);
                break;
            case Direction.RIGHT:
                setDirection(Direction.DOWN);
                break;
            case Direction.DOWN:
                setDirection(Direction.LEFT);
                break;
            case Direction.LEFT:
                setDirection(Direction.UP);
                break;
        }
    }
}
