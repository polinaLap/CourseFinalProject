package ua.univ.services.user;

import ua.univ.dao.TestDAO;
import ua.univ.exceptions.DataBaseException;
import ua.univ.factories.DAOFactory;

import java.util.List;

public class TestListService {
    private static final DAOFactory daoFactory=DAOFactory.getInstance();
    public List<List<String>> getTests(){
        TestDAO t = daoFactory.getTestDAO();
        try {
           return t.getAllTests();
        }
        catch (DataBaseException e){
            return null;
        }
    }
}
