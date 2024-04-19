package walking.game;

import walking.game.util.Direction;

public class WalkingBoard {

    private int[][] tiles;
    private int x = 0;
    private int y = 0;
    public final static int BASE_TILE_SCORE = 3;

    public WalkingBoard(int size) {
        this.tiles = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                tiles[i][j] = BASE_TILE_SCORE;
            }
        }
    }

    public WalkingBoard(int[][] tiles) {
        int[][] copy = new int[tiles.length][tiles.length];
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[0].length; j++) {
                if (tiles[i][j] != BASE_TILE_SCORE) {
                    tiles[i][j] = BASE_TILE_SCORE;
                    copy[i][j] = tiles[i][j];
                } else {
                    copy[i][j] = tiles[i][j];
                }
            }
        }
        this.tiles = copy;
    }

    public int[][] getTiles() {

        int[][] copy = new int[this.tiles.length][this.tiles.length];

        for (int i = 0; i < this.tiles.length; i++) {
            for (int j = 0; j < this.tiles[0].length; j++) {
                copy[i][j] = tiles[i][j];
            }
        }

        return copy;

    }

    public int getTile(int x, int y) throws IllegalArgumentException {
        if (isValidPosition(x, y)) {
            return tiles[x][y];
        } else {
            throw new IllegalArgumentException();
        }
    }

    public int[] getPosition() {
        int[] a = new int[2];
        a[0] = this.x;
        a[1] = this.y;
        return a;
    }

    public boolean isValidPosition(int x, int y) {
        int maxX = this.tiles.length - 1;
        int maxY = this.tiles[0].length - 1;

        if (x >= 0 && x <= maxX && y >= 0 && y <= maxY) {
            return true;
        } else {
            return false;
        }
    }

    public static int getXStep(Direction direction) {
        switch (direction) {
            case Direction.UP:
                return 0;
            case Direction.DOWN:
                return 0;
            case Direction.LEFT:
                return -1;
            case Direction.RIGHT:
                return 1;

            default:
                throw new IllegalArgumentException("Wrong direction input(e.g.: DOWN)");
        }
    }

    public static int getYStep(Direction direction) {
        switch (direction) {
            case Direction.UP:
                return -1;
            case Direction.DOWN:
                return 1;
            case Direction.LEFT:
                return 0;
            case Direction.RIGHT:
                return 0;

            default:
                throw new IllegalArgumentException("Wrong direction input(e.g.: DOWN)");
        }
    }

    public int moveAndSet(Direction direction, int value) {

        int setX = x + getXStep(direction);
        int setY = y + getYStep(direction);

        if (!isValidPosition(setX, setY)) {
            return 0;
        } else {
            int oldValue = tiles[x][y];
            tiles[x][y] = value;
            x = setX;
            y = setY;
            return oldValue;
        }
    }

}