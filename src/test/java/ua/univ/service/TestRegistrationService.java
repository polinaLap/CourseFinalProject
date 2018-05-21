package ua.univ.service;

import org.junit.Before;
import org.junit.Test;
import ua.univ.factories.ServiceFactory;
import ua.univ.pool.ConnectionPool;
import ua.univ.resource.DataSource;
import static org.junit.Assert.*;
import ua.univ.services.common.RegistrateService;

public class TestRegistrationService {
    private static ConnectionPool pool=ConnectionPool.getInstance();
    private RegistrateService rs = ServiceFactory.getInstance().getRegistrateService();
    @Before
    public void start(){
        pool.setConnectionString(DataSource.getProperty("testConnectionString"));
        pool.setUser(DataSource.getProperty("testLogin"));
        pool.setPassword(DataSource.getProperty("testPassword"));
    }
    @Test
    public void testRegistrate_ok(){
        boolean res = rs.registrate("Vlad","vlad@gmail.com","vlad");
        assertTrue(res);
    }
    @Test
    public void testRegistrate_UserAlreadyExists(){
        boolean res = rs.registrate("Alex2","alex@gmail.com","alex2");
        assertFalse(res);
    }
}
