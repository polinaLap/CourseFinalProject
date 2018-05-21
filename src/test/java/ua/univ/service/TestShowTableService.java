package ua.univ.service;

import org.junit.Before;
import org.junit.Test;
import ua.univ.entities.User;
import ua.univ.factories.ServiceFactory;
import ua.univ.pool.ConnectionPool;
import ua.univ.resource.DataSource;
import ua.univ.services.admin.ShowTableService;
import ua.univ.services.user.CheckTestService;

import java.util.List;

import static org.junit.Assert.*;

public class TestShowTableService {
    private ShowTableService ss = ServiceFactory.getInstance().getShowTableService();
    private static ConnectionPool pool=ConnectionPool.getInstance();
    @Before
    public void start(){
        pool.setConnectionString(DataSource.getProperty("testConnectionString"));
        pool.setUser(DataSource.getProperty("testLogin"));
        pool.setPassword(DataSource.getProperty("testPassword"));
    }
    @Test
    public void checkOrderOfStudents(){
        List<User> users = ss.getTable();
        boolean res=true;
        for (int i = 0; i < users.size()-1; i++) {
            if(users.get(i).getSuccess().averageMark()<users.get(i+1).getSuccess().averageMark()){
                res=false;
                break;
            }
        }
        assertTrue(res);
    }
}
