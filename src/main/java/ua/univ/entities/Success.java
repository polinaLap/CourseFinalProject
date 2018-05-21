package ua.univ.entities;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;

public class Success implements Comparable<Success>{
    private Map<Test,List<Integer>> success = new HashMap<>();
    public float averageMark(Test test){
        int sum =0;
        for (int mark: success.get(test)){
            sum+=mark;
        }
        return ((float)sum)/success.get(test).size();
    }
    public float averageMark(){
        int sum =0;
        int n=0;
        for (Test test:success.keySet()) {
        for (int mark: success.get(test)){
            sum+=mark;n++;
        }
        }
        return ((float)sum)/n;
    }
    public int maxMark(Test test){

        return Collections.max(success.get(test));
    }
    public int attemptCount(Test test){
        return success.get(test).size();
    }

    public Map<Test,List<Integer>> getSuccess() {
        return success;
    }
    public void addTestMark(Test test, int mark){
        if(!success.containsKey(test)){
            success.put(test,new ArrayList<Integer>());
        }
        success.get(test).add(mark);
    }

    @Override
    public int compareTo(Success o) {
        int res=-1;
        Set<Test> testSet1 = this.getSuccess().keySet();
        Set<Test> testSet2 = o.getSuccess().keySet();
        testSet1.retainAll(testSet2);
        float avMarkSum1 = 0;
        float avMarkSum2 = 0;
        for (Test test:testSet1) {
            avMarkSum1 += this.averageMark(test);
            avMarkSum2 += o.averageMark(test);
        }
        if(avMarkSum1<avMarkSum2) return -1;
        if(avMarkSum1>avMarkSum2) return 1;
        return 0;
    }

}
