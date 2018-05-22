package ua.univ.entities;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;

public class Success {
    private Map<String,List<Integer>> success = new HashMap<>();
    public float averageMark(String test){
        int sum =0;
        for (int mark: success.get(test)){
            sum+=mark;
        }
        return ((float)sum)/success.get(test).size();
    }
    public float averageMark(){
        int sum =0;
        int n=0;
        for (String test:success.keySet()) {
        for (int mark: success.get(test)){
            sum+=mark;n++;
        }
        }
        return ((float)sum)/n;
    }
    public int maxMark(String test){

        return Collections.max(success.get(test));
    }
    public int attemptCount(String test){
        return success.get(test).size();
    }

    public Map<String,List<Integer>> getSuccess() {
        return success;
    }
    public void addTestMark(String test, int mark){
        if(!success.containsKey(test)){
            success.put(test,new ArrayList<Integer>());
        }
        success.get(test).add(mark);
    }


}
