package _05gyak.math.operation.safe;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import _05gyak.math.operation.safe.IncrementTest;

@Suite
@SelectClasses({
    IncrementStructureTest.class,
    IncrementTest.class
})
public class IncrementTestSuite {}

