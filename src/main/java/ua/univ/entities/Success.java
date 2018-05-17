package ua.univ.entities;

import java.util.*;

public class Success implements Comparable<Success>{
    private Map<Test,List<Mark>> success = new HashMap<>();
    private float countAverageMark(Test test){
        int sum =0;
        for (Mark mark: success.get(test)){
            sum+=mark.getValue();
        }
        return ((float)sum)/success.get(test).size();
    }

    public Map<Test,List<Mark>> getSuccess() {
        return success;
    }
    public void addTestMark(Test test, Mark mark){
        if(!success.containsKey(test)){
            success.put(test,new ArrayList<Mark>());
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
            avMarkSum1 += this.countAverageMark(test);
            avMarkSum2 += o.countAverageMark(test);
        }
        if(avMarkSum1<avMarkSum2) return -1;
        if(avMarkSum1>avMarkSum2) return 1;
        return 0;
    }

}
