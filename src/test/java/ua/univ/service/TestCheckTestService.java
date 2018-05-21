package ua.univ.service;
import org.junit.Before;
import org.junit.Test;
import ua.univ.entities.Question;
import ua.univ.entities.User;
import ua.univ.factories.ServiceFactory;
import ua.univ.pool.ConnectionPool;
import ua.univ.resource.DataSourceManager;
import ua.univ.services.user.CheckTestService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
public class TestCheckTestService {
    private CheckTestService cs = ServiceFactory.getInstance().getCheckTestService();
    private ua.univ.entities.Test test;
    private static ConnectionPool pool=ConnectionPool.getInstance();
    @Before
    public void start(){
        pool.setConnectionString(DataSourceManager.getProperty("testConnectionString"));
        pool.setUser(DataSourceManager.getProperty("testLogin"));
        pool.setPassword(DataSourceManager.getProperty("testPassword"));
        createObjects();
    }
    private void createObjects(){
        List<String> answers1= new ArrayList<>();
        answers1.add("ans1");
        answers1.add("ans2");
        Question q1 = new Question("q1",answers1,1);
        List<String> answers2= new ArrayList<>();
        answers2.add("ans3");
        answers2.add("ans4");
        Question q2= new Question("q2",answers2,2);
        List<Question> questions = new ArrayList<>(2);
        questions.add(q1); questions.add(q2);
        test = new ua.univ.entities.Test("test","desc",questions);
    }
    @Test
    public void testUsualTest(){
        User user = new User("Alex","alex@gmail.com","alex");
        List<String> answers = new ArrayList<>(2);
       answers.add("ans1");
        answers.add("ans3");
        assertEquals(1,cs.check(test,answers,user));
    }
    @Test
    public void testUsualTestForNullUser(){
        User user = null;
        List<String> answers = new ArrayList<>(2);
        answers.add("ans1");
        answers.add("ans3");
        assertEquals(-1,cs.check(test,answers,user));
    }
}
