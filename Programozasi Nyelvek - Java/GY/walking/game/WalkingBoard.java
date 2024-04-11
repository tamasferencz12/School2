package walking.game;
import walking.game.util.Direction;

public class WalkingBoard{
        
    private int[][] tiles;
    private int x;
    private int y;
    public final static int BASE_TILE_SCORE = 3;

    public void setTiles(int[][] tiles){
        this.tiles = tiles;
    }

    public int getY(){
        return y;
    }

    public void setY(int y){
        this.y = y;
    }

    public WalkingBoard(int size){
        tiles = new int[size][size];
        x = size;
        y = size;
    }

    public WalkingBoard(int[][] tiles){
        this.tiles = tiles;
    }

    public int[][] getTiles(){
        int[][] copy = new int[x][y];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                copy[i][j] = tiles[i][j];
            }
        }

        return copy;
    }

    public int getTile(int x, int y) throws IllegalArgumentException{
        return tiles[x][y];
    }

    public int[] getPosition(){
        int[] a = new int[0];
        return a;
    }

    public boolean isValidPosition(int x, int y){
        return false;
    }

    public static int getXStep(Direction direction ){
        return 0;
    }

    public static int getYStep(Direction direction){
       return 0;
    }

    public int moveAndSet(Direction direction,int value){
        return 0;
    }

}