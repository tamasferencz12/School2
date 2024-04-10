package _06gyak.array.util.main;

import static check.CheckThat.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.extension.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import check.*;

public class ArrayUtilTest{

    @ParameterizedTest
    @CsvSource(textBlock = """
        0, 0
        0, 0
        0, 0
        0, 0
    """)

    public void maxLength0(int expected){
        int[] arr = {};
        assertEquals(expected, ArrayUtil.max(arr));
        assertEquals(expected, ArrayUtil.max2(arr));
        assertEquals(expected, ArrayUtil.max3(arr));
        assertEquals(expected, ArrayUtil.max4(arr));
    }

    @ParameterizedTest
    @CsvSource(textBlock = """
        0, 0
        1, 1
        100, 100
        -5, -5
    """)

    public void maxLength1(int max,int expected){
        int[] arr = {max};
        assertEquals(expected, ArrayUtil.max(arr));
        assertEquals(expected, ArrayUtil.max2(arr));
        assertEquals(expected, ArrayUtil.max3(arr));
        assertEquals(expected, ArrayUtil.max4(arr));
    }

    @ParameterizedTest
    @CsvSource(textBlock = """
        0, 2, 2
        -1, 1, 1
        -7, -2, -2
    """)

    public void maxLength2(int min,int max,int expected){
        int[] arr = {min, max};
        assertEquals(expected, ArrayUtil.max(arr));
        assertEquals(expected, ArrayUtil.max2(arr));
        assertEquals(expected, ArrayUtil.max3(arr));
        assertEquals(expected, ArrayUtil.max4(arr));
        arr[0] = max;
        arr[1] = min;
        assertEquals(expected, ArrayUtil.max(arr));
        assertEquals(expected, ArrayUtil.max2(arr));
        assertEquals(expected, ArrayUtil.max3(arr));
        assertEquals(expected, ArrayUtil.max4(arr));
    }

    @ParameterizedTest
    @CsvSource(textBlock = """
        2, 3, 2, 3
        1, 6, 1, 6
        123, 454, 123, 454
    """)

    public void minMaxLengthN(int min,int max,int minR, int maxR){
        int[] arr = {min, max};
        int[] expected = {minR, maxR};
        assertArrayEquals(expected, ArrayUtil.minMax(arr));
    }
}