package ua.univ.factories;


import ua.univ.services.admin.AddTestService;
import ua.univ.services.admin.ShowTableService;
import ua.univ.services.common.LoginService;
import ua.univ.services.common.RegistrateService;
import ua.univ.services.user.CheckTestService;
import ua.univ.services.user.TestListService;
import ua.univ.services.user.TestService;
import ua.univ.services.user.UserSuccessService;

public class ServiceFactory {
    private static ServiceFactory instance = new ServiceFactory();
    private LoginService loginService;
    private RegistrateService registrateService;


    private CheckTestService checkTestService;
    private TestListService testListService;
    private TestService testService;
    private UserSuccessService userSuccessService;
    private AddTestService addTestService;
    private ShowTableService showTableService;

    private ServiceFactory() {
        loginService= new LoginService();
        registrateService=new RegistrateService();
        checkTestService=new CheckTestService();
        testListService= new TestListService();
        testService = new TestService();
        userSuccessService= new UserSuccessService();
        addTestService= new AddTestService();
        showTableService = new ShowTableService();
    }
    public static ServiceFactory getInstance(){
        return instance;
    }
    public LoginService getLoginService() {
        return loginService;
    }

    public RegistrateService getRegistrateService() {
        return registrateService;
    }

    public CheckTestService getCheckTestService() {
        return checkTestService;
    }

    public TestListService getTestListService() {
        return testListService;
    }

    public TestService getTestService() {
        return testService;
    }

    public UserSuccessService getUserSuccessService() {
        return userSuccessService;
    }

    public AddTestService getAddTestService() {
        return addTestService;
    }

    public ShowTableService getShowTableService() {
        return showTableService;
    }

}
