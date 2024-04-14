package walking.game.tests;

import walking.game.*;

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
        assertEquals(size, board.getSize());
    }

    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 6 })
    public void getTilesTest(int size) {
        WalkingBoard board = new WalkingBoard(size);
        assertEquals(size, board.getTiles().length);
    }
}
