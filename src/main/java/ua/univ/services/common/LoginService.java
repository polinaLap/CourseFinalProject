package ua.univ.services.common;

import ua.univ.dao.UserDAO;
import ua.univ.entities.User;
import ua.univ.entities.UserType;
import ua.univ.exceptions.DataBaseException;
import ua.univ.factories.DAOFactory;
import ua.univ.resource.DataSourceManager;

public class LoginService {
    private static final String ADMIN_LOGIN = DataSourceManager.getProperty("adminEmail");
    private static final DAOFactory daoFactory=DAOFactory.getInstance();
    public User checkLogin(String enterLogin, String enterPass) {
        UserDAO ud = daoFactory.getUserDAO();
        User user=null;
        try{
            user = ud.getUser(enterLogin);
            if(user==null||!user.getPassword().equals(enterPass)) return null;
            setUserType(user);
        }
        catch (DataBaseException e){
            return null;
        }
        return user;
    }
    private static void setUserType(User user){
        if(user.getEmail().equals(ADMIN_LOGIN)) user.setType(UserType.ADMIN);
    }
}
