package ua.univ.service;

import org.junit.Before;
import org.junit.Test;
import ua.univ.entities.User;
import ua.univ.entities.UserType;
import ua.univ.factories.ServiceFactory;
import ua.univ.pool.ConnectionPool;
import ua.univ.resource.DataSourceManager;
import ua.univ.services.common.LoginService;
import static org.junit.Assert.*;

public class TestLoginService {

    private static ConnectionPool pool=ConnectionPool.getInstance();
    private LoginService ls = ServiceFactory.getInstance().getLoginService();
    @Before
    public void start(){
        pool.setConnectionString(DataSourceManager.getProperty("testConnectionString"));
        pool.setUser(DataSourceManager.getProperty("testLogin"));
        pool.setPassword(DataSourceManager.getProperty("testPassword"));
    }
    @Test
    public void testUser_ok(){
        User user = ls.checkLogin("alex@gmail.com","alex");
        assertEquals(UserType.STUDENT,user.getType());
    }
    @Test
    public void testUser_notOk(){
        User user = ls.checkLogin("not","not");
        assertNull(user);
    }
    @Test
    public void testAdmin_ok(){
        User user = ls.checkLogin(DataSourceManager.getProperty("adminEmail"),DataSourceManager.getProperty("adminPassword"));
        assertEquals(UserType.ADMIN,user.getType());
    }
}
