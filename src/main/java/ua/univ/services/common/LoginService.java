package ua.univ.services.common;

import ua.univ.dao.UserDAO;
import ua.univ.entities.User;
import ua.univ.entities.UserType;
import ua.univ.resource.DataSourceManager;

public class LoginService {

    private static final String ADMIN_LOGIN = DataSourceManager.getProperty("adminEmail");
    public User checkLogin(String enterLogin, String enterPass) {
        UserDAO st = new UserDAO();
        User user = st.getUser(enterLogin);
        if(user==null||!user.getPassword().equals(enterPass)) return null;
        setUserType(user);
        return user;
    }
    private static void setUserType(User user){
        if(user.getEmail().equals(ADMIN_LOGIN)) user.setType(UserType.ADMIN);
    }
}
