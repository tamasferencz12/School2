package walking.game.tests.structureTests;

import walking.game.*;
import walking.game.util.Direction;

import static check.CheckThat.*;
import static check.CheckThat.Condition.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import check.CheckThat;

public class MadlyRotatingBucaneerStructureTest {
    @BeforeAll
    public static void init() {
        CheckThat.theClass("walking.game.player.MadlyRotatingBucaneer")
                .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL);
    }

    @Test
    @DisabledIf(notApplicable)
    public void fieldCalls() {
        it.hasField("calls: int")
                .thatIs(INSTANCE_LEVEL, MODIFIABLE, VISIBLE_TO_NONE)
                .thatHasNo(GETTER)
                .thatHasNo(SETTER);
    }

    @Test
    @DisabledIf(notApplicable)
    public void constructor() {
        it.hasConstructor(withNoArgs())
                .thatIs(VISIBLE_TO_ALL);
    }

    @Test
    @DisabledIf(notApplicable)
    public void methodTurn() {
        it.hasMethod("turn", withNoParams())
                .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
                .thatReturnsNothing();
    }
}
