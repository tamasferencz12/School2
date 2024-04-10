package _04gyak.famous.sequence;

import static check.CheckThat.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.extension.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import check.*;

public class TriangularNumbersTest{
    @Test
    public void triNum0(){
        //List<int> expected = Arrays.asList();
        assertEquals(0, TriangularNumbers.getTriangularNumber(0));
    }

    @Test
    public void triNum1(){
        assertEquals(1, TriangularNumbers.getTriangularNumber(1));
    }

    @Test
    public void triNum2(){
        assertEquals(0, TriangularNumbers.getTriangularNumber(-1));
    }

    @Test
    public void triNum3(){
        assertEquals(0, TriangularNumbers.getTriangularNumber(-5));
    }

    @ParameterizedTest
    @CsvSource(textBlock = """
        0, 0
        1, 1
        0, -1
        10, -5
    """)

    public void triNums(int expected, int n){
        assertEquals(expected, TriangularNumbers.getTriangularNumberAlternative(n));
    }
}