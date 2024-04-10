package _08gyak.worker.schedule;

import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Map.Entry; // kulon van, egyebkent import java.util.*;

public class WorkerSchedule {

    //private HashMap< Integer, HashSet<String> > weekToWorkers = new HashMap<Integer, HashSet<String>>();
    //private HashMap< Integer, HashSet<String> > weekToWorkers = new HashMap<>();
    private HashMap< Integer, HashSet<String> > weekToWorkers;

    public WorkerSchedule(){
        weekToWorkers = new HashMap<>();
    }

    public void add (int week, HashSet<String> newWorkers){
        if (!weekToWorkers.containsKey(week)) {
            weekToWorkers.put(week, new HashSet<String>()); //memoria lefoglalas
        }

        HashSet<String> workers = weekToWorkers.get(week);  //lefoglalt terulet feltoltese

        for (String worker : newWorkers) {
            workers.add(worker);
        }

        //workers.addAll(newWorkers);  //foreach helyett
        //weekToWorkers.get(week).addAll(newWorkersworkers);
    }

    public void add(HashSet<Integer> weeks, ArrayList<String> newWorkers){
        HashSet<String> nws = new HashSet<>();
        nws.addAll(newWorkers);
        for(Integer week : weeks){
            add(week, nws);         // sajat add metodusunk fentebb
        }
    }

    public boolean isWorkingOnWeek(String worker, int week){

        if (!weekToWorkers.containsKey(week)) {
            return false;
        }

        HashSet<String> workers = weekToWorkers.get(week);

        return workers.contains(worker);

        // return weekToWorkers.get(week).contains(worker);
    }

    public HashSet<Integer> getWorkWeeks (String worker){
        HashSet<Integer> assignment = new HashSet<>();
        for( Entry<Integer, HashSet<String>> entry : weekToWorkers.entrySet()){
            Integer week = entry.getKey();
            if (isWorkingOnWeek(worker, week)) {
                assignment.add(week);
            }
        } 

        return assignment;
    }

    public boolean emptySchedule(){
        return weekToWorkers.isEmpty();
    }
}
