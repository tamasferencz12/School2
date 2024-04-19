package walking.game.tests.testSuites;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import walking.game.tests.testSuites.WalkingBoardBasicTestSuite;
import walking.game.tests.testSuites.WalkingBoardExtendedTestSuite;

@SelectClasses({
    WalkingBoardBasicTestSuite.class, WalkingBoardExtendedTestSuite.class
})
@Suite
public class WalkingBoardFullTestSuite {
}
