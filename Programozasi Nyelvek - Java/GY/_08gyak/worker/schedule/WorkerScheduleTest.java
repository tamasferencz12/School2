package _08gyak.worker.schedule;

import static check.CheckThat.*;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.extension.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import check.*;

public class WorkerScheduleTest {

    @Test
    public void emptySchedule(){
        WorkerSchedule ws = new WorkerSchedule();
        assertTrue(ws.emptySchedule());
        assertFalse( !ws.emptySchedule());
    }

    @Test
    public void isWorkingOnWeekTest(){
        WorkerSchedule ws = new WorkerSchedule();
        ws.add(1, new HashSet<>(Arrays.asList("John", "Jack", "Jill", "Judy")));
        ws.add(2, new HashSet<>(List.of("John", "Joe", "Bill", "Judy")));

        assertTrue(ws.isWorkingOnWeek("John", 1));
        assertFalse( ws.isWorkingOnWeek("Jill", 2));
        assertFalse( ws.isWorkingOnWeek("Mary", 2));
        assertFalse( ws.isWorkingOnWeek("John", 3));
    }

    @Test
    public void getWorkWeeksTest(){
        WorkerSchedule ws = new WorkerSchedule();
        ws.add(new HashSet<>(Arrays.asList(1,2,3)), new ArrayList<>(List.of("John", "Jack")));
        ws.add(new HashSet<>(Arrays.asList(2,3,4)), new ArrayList<>(List.of("John", "Mark", "Mary")));
        HashSet<Integer> weeksJohn = ws.getWorkWeeks("John");
        HashSet<Integer> weeksMark = ws.getWorkWeeks("Mark");
        System.out.println(weeksJohn);
        System.out.println(weeksMark);
        System.out.println(ws);

        int[] expected = new int[]{1,2,3,4};
        for (int i = 0; i < weeksJohn.size(); i++) {
            assertTrue(weeksJohn.contains(expected[i]));
        }

        for (int i = 0; i < weeksMark.size(); i++) {
            assertTrue(weeksMark.contains(expected[i + 1]));
        }
    }
}
