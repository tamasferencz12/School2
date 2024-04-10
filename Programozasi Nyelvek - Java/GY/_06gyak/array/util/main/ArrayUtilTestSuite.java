package _06gyak.array.util.main;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import _06gyak.array.util.main.ArrayUtilTest;

@Suite
@SelectClasses({
	ArrayUtilStructureTest.class,
	ArrayUtilTest.class
})
public class ArrayUtilTestSuite {}

