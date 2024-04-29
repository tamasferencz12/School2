package walking.game.player;

import walking.game.util.Direction;

public class MadlyRotatingBucaneer extends Player {

    private int calls;

    public MadlyRotatingBucaneer() {

    }

    @Override
    public void turn() {
        for (int i = 0; i < calls; i++) {
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
        calls += 1;

    }
}
