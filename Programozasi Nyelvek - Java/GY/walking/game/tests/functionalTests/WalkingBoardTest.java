package walking.game.tests.functionalTests;

import walking.game.*;
import walking.game.util.Direction;

import static check.CheckThat.*;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.extension.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import check.*;

public class WalkingBoardTest {

    @ParameterizedTest
    @ValueSource(ints = { 3, 4, 5 })
    public void testSimpleInit(int size) {
        WalkingBoard board = new WalkingBoard(size);
        int[][] tiles = board.getTiles();

        assertEquals(size, tiles.length);

        for (int i = 0; i < size; i++) {
            assertNotNull(tiles[i][size - 1]);
            for (int j = 0; j < size; j++) {
                assertNotNull(tiles[size - 1][j]);
                assertEquals(WalkingBoard.BASE_TILE_SCORE, tiles[i][j]);
            }
        }
    }

    @ParameterizedTest
    @CsvSource(textBlock = """
                2, 2, 3
                3, 3, 3
                6, 6, 3
            """)
    public void testCustomInit(int x, int y, int expected) {
        int[][] firstBoard = new int[x][y];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                firstBoard[i][j] = 1;
            }
        }

        WalkingBoard board = new WalkingBoard(firstBoard);

        assertEquals(expected, board.getTile(x - 2, y - 2));
        firstBoard[x - 1][y - 1] = 2;
        assertEquals(expected, board.getTile(x - 1, y - 1));

        int[][] secondBoard = board.getTiles();

        secondBoard[x - 1][y - 1] = 10;

        assertEquals(expected, board.getTile(x - 1, y - 1));
    }

    @Test
    public void testMoves() {

        WalkingBoard board = new WalkingBoard(2);

        assertEquals(3, board.moveAndSet(Direction.RIGHT, 4));
        assertEquals(3, board.moveAndSet(Direction.DOWN, 4));
        assertEquals(3, board.moveAndSet(Direction.LEFT, 4));
        assertEquals(3, board.moveAndSet(Direction.UP, 4));
        assertEquals(4, board.moveAndSet(Direction.RIGHT, 5));
        assertEquals(0, board.moveAndSet(Direction.UP, 5));

    }

}
