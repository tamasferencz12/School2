package walking.game.tests;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import walking.game.tests.WalkingBoardTest;
import walking.game.tests.WalkingBoardStructureTest;

@SelectClasses({
    WalkingBoardBasicTestSuite.StructuralTests.class, WalkingBoardBasicTestSuite.FunctionalTests.class
})
@Suite
public class WalkingBoardBasicTestSuite {
  @SelectClasses({
      DirectionStructureTest.class, WalkingBoardStructureTest.class
  })
  @Suite
  public static class StructuralTests {
  }

  @SelectClasses({
      WalkingBoardTest.class
  })
  @Suite
  public static class FunctionalTests {
  }
}
