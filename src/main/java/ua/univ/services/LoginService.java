package ua.univ.services;

import ua.univ.dao.UserDAO;
import ua.univ.entities.User;
import ua.univ.entities.UserType;

public class LoginService {

    private static final String ADMIN_LOGIN = "admin@test.com";
    public static User checkLogin(String enterLogin, String enterPass) {
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
