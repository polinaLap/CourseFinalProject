package ua.univ.services.common;

import ua.univ.dao.UserDAO;
import ua.univ.entities.User;
import ua.univ.exceptions.DataBaseException;
import ua.univ.factories.DAOFactory;
import ua.univ.transaction.Transaction;

public class RegistrateService {
    private static final DAOFactory daoFactory=DAOFactory.getInstance();
    public boolean registrate(String name, String email, String password) {
        UserDAO ud = daoFactory.getUserDAO();
        try{
            try{
            Transaction.beginTransaction();
            if(ud.getUser(email)!=null) return false;
            User u = new User(name,email,password);
            ud.addUser(u);
            Transaction.commit();
            }catch (DataBaseException e){
                Transaction.rollback();
                return false;
            }
            finally {
                Transaction.endTransaction();
            }
        }
        catch (DataBaseException e){
            return false;
        }
        return true;
    }
}
