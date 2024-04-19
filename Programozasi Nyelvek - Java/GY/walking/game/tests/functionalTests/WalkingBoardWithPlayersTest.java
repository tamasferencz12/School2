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

public class WalkingBoardWithPlayersTest {

    @Test
    public void walk1() {
        WalkingBoardWithPlayers board = new WalkingBoardWithPlayers(10, 3);

        int[] x = board.walk(1, 2, 3, 4, 5, 6, 7, 8, 9);

        int[] y = { 27, 12, 15 };
        assertArrayEquals(y, x);
    }

    @Test
    public void walk2() {
        WalkingBoardWithPlayers board = new WalkingBoardWithPlayers(5, 2);

        int[] x = board.walk(1, 2, 3, 4, 5, 6);

        int[] y = { 12, 12 };
        assertArrayEquals(y, x);
    }

}
