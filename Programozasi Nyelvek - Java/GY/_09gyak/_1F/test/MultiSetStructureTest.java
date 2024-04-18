package _09gyak._1F.test;

import static check.CheckThat.*;
import static check.CheckThat.Condition.*;
import org.junit.jupiter.api.*;
import check.CheckThat;

public class MultiSetStructureTest {
    @BeforeAll
    public static void init() {
        CheckThat.theClass("_09gyak._1F.data.structure.MultiSet")
                .withTypeParameter("E")
                .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL);
    }

    @Test
    public void fieldElemToCount() {
        it.hasField("elemToCount: HashMap of E to Integer")
                .thatIs(INSTANCE_LEVEL, MODIFIABLE, VISIBLE_TO_NONE)
                .thatHasNo(GETTER, SETTER);
    }

    @Test
    public void constructor() {
        it.hasConstructor(withParams("array of E"))
                .thatIs(VISIBLE_TO_ALL);
    }

    @Test
    public void methodAdd() {
        it.hasMethod("add", withParams("E"))
                .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
                .thatReturns("int");
    }

    @Test
    public void methodGetCount() {
        it.hasMethod("getCount", withParams("E"))
                .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
                .thatReturns("Multiset of E");
    }

    @Test
    public void methodIntersect() {
        it.hasMethod("intersect", withParams("MultiSet of E"))
                .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
                .thatReturns("MultiSet of E");
    }

    @Test
    public void methodSize() {
        it.hasMethod("size", withNoParams())
                .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
                .thatReturns("int");
    }
}
