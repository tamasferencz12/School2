package walking.game.tests.testSuites;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import walking.game.tests.functionalTests.WalkingBoardWithPlayersTest;
import walking.game.tests.structureTests.PlayerStructureTest;
import walking.game.tests.structureTests.WalkingBoardWithPlayersStructureTest;

@SelectClasses({
        WalkingBoardExtendedTestSuite.StructuralTests.class, WalkingBoardExtendedTestSuite.FunctionalTests.class
})
@Suite
public class WalkingBoardExtendedTestSuite {
    @SelectClasses({
            WalkingBoardWithPlayersStructureTest.class, PlayerStructureTest.class
    })
    @Suite
    public static class StructuralTests {
    }

    @SelectClasses({
            WalkingBoardWithPlayersTest.class
    })
    @Suite
    public static class FunctionalTests {
    }
}
