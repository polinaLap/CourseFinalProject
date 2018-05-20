package ua.univ.factories;

        import ua.univ.commands.IActionCommand;
        import ua.univ.commands.CommandEnum;
        import ua.univ.commands.EmptyCommand;
        import ua.univ.resource.MessageManager;

        import javax.servlet.http.HttpServletRequest;

public class ActionFactory {
    private static  ActionFactory instance = new ActionFactory();
    private ActionFactory(){}
    public static ActionFactory getInstance(){return instance; }
    public IActionCommand defineCommand(HttpServletRequest request){
        IActionCommand current = new EmptyCommand();
        String action = request.getParameter("command");
        if(action==null||action.isEmpty()){
            return current;
        }
        try{
            CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
            current = currentEnum.getCurrentCommand();
        }
        catch (IllegalArgumentException e){
            request.setAttribute("wrongAction",action+MessageManager.getProperty("message.wrongaction"));
        }
        return current;
    }


}
