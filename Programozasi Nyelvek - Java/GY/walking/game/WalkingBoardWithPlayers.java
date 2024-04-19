package walking.game;

import walking.game.player.Player;
import walking.game.WalkingBoard;
import walking.game.player.MadlyRotatingBucaneer;

public class WalkingBoardWithPlayers extends WalkingBoard {

    private Player[] players;
    private int round;
    public static final int SCORE_EACH_STEP = 13;

    public WalkingBoardWithPlayers(int[][] tiles, int playerCount) {
        super(tiles);
        players = new Player[playerCount];
        initPlayers(playerCount);
    }

    public WalkingBoardWithPlayers(int size, int playerCount) {
        super(size);
        players = new Player[playerCount];
        initPlayers(playerCount);
    }

    private void initPlayers(int playerCount) {

        if (playerCount < 2) {
            throw new IllegalArgumentException();
        }
        players[0] = new MadlyRotatingBucaneer();
        for (int i = 1; i < playerCount; i++) {
            players[i] = new Player();
        }
    }

    public int[] walk(int... stepCounts) {
        int index = 0;
        // System.out.println("Player length: " + players.length + ", steps length: " +
        // stepCounts.length);
        for (int i = 0; i < stepCounts.length; i++) {
            players[index].turn();
            for (int j = 0; j < stepCounts[i]; j++) {
                if (j <= SCORE_EACH_STEP) {
                    players[index].addToScore(moveAndSet(players[index].getDirection(), j));
                }
                players[index].addToScore(moveAndSet(players[index].getDirection(), SCORE_EACH_STEP));
            }
            if (index + 1 >= players.length) {
                index = 0;
            } else {
                index++;
            }
        }
        int[] scores = new int[players.length];

        for (int i = 0; i < scores.length; i++) {
            scores[i] = players[i].getScore();
        }
        return scores;
    }

}
