package _05gyak.math.operation.textual;

import static check.CheckThat.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.extension.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import check.*;

public class AdderTest{
    @Test
    public void inc0(){
        assertEquals(1, Increment.increment(0));
    }

    @Test
    public void inc1(){
        assertEquals(Integer.MIN_VALUE + 1, Increment.increment(Integer.MIN_VALUE));
    }

    @Test
    public void inc2(){
        
        assertEquals(Integer.MAX_VALUE, Increment.increment(Integer.MAX_VALUE));
    }


    @ParameterizedTest
    @CsvSource(textBlock = """
        1, 0
        2, 1
        0, -1
        -4, -5
    """)

    public void incs(int expected, int n){
        assertEquals(expected, Adder.addAsText(n));
    }
}