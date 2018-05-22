package ua.univ.services.user;

import ua.univ.dao.SuccessDAO;
import ua.univ.entities.User;
import ua.univ.exceptions.DataBaseException;
import ua.univ.factories.DAOFactory;

import java.util.List;

public class UserSuccessService {
    private static final DAOFactory daoFactory=DAOFactory.getInstance();
    public boolean getSuccess(User user){
        SuccessDAO s = daoFactory.getSuccessDAO();
        try{
            user.setSuccess(s.getSuccess(user));
            return true;
        }
        catch (DataBaseException e){
            return false;
        }
    }
}
