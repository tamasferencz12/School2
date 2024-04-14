package walking.game;

import walking.game.util.Direction;

public class WalkingBoard {

    private int[][] tiles;
    private int x;
    private int y;
    public final static int BASE_TILE_SCORE = 3;

    // helper function
    public int getSize() {
        return this.tiles.length;
    }

    public WalkingBoard(int size) {
        this.tiles = new int[size][size];
        this.x = size;
        this.y = size;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                tiles[i][j] = BASE_TILE_SCORE;
            }
        }
    }

    public WalkingBoard(int[][] tiles) {
        int[][] copy = new int[tiles.length][tiles.length];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (tiles[i][j] != BASE_TILE_SCORE) {
                    throw new IllegalArgumentException();
                } else {
                    copy[i][j] = tiles[i][j];
                }
            }
        }
    }

    public int[][] getTiles() {
        /*
         * int[][] copy = new int[x][y];
         * 
         * for (int i = 0; i < x; i++) {
         * for (int j = 0; j < y; j++) {
         * copy[i][j] = tiles[i][j];
         * }
         * }
         * 
         * return copy;
         */
        return this.tiles.clone();
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
        if ((x < 0 || x > this.x) || (y < 0 || y > this.y)) {
            return false;
        } else {
            return true;
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
            x -= getXStep(direction);
            y -= getYStep(direction);
            return 0;
        } else {
            int oldValue = tiles[setX][setY];
            tiles[setX][setY] = value;

            return oldValue;
        }
    }

}