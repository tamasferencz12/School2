package walking.game;

import walking.game.player.Player;
import walking.game.WalkingBoard;

public class WalkingBoardWithPlayers extends WalkingBoard {

    private Player[] players;
    private int round;
    public static final int SCORE_EACH_STEP = 13;

    public WalkingBoardWithPlayers(int[][] board, int playerCount) {
        super(board);
        initPlayers(playerCount);
    }

    public WalkingBoardWithPlayers(int size, int playerCount) {
        super(size);
        initPlayers(playerCount);
    }

    private void initPlayers(int playerCount) {

        if (playerCount < 2) {
            throw new IllegalArgumentException();
        }
        players[0] = new MadlyRotatingBuccaneer();
        for (int i = 1; i < playerCount; i++) {
            players[i] = new Player();
        }
    }

    public int[] walk(int... stepCounts) {
        int[] x = new int[1];
        return x;
    }

}
