package ua.univ.commands;

import ua.univ.commands.admin.AddTestCommand;
import ua.univ.commands.admin.ShowTableCommand;
import ua.univ.commands.common.LoginCommand;
import ua.univ.commands.common.LogoutCommand;
import ua.univ.commands.user.*;

public enum CommandEnum {
    LOGIN{
        {
            this.command = new LoginCommand();
        }
    },
    LOGOUT{
        {
            this.command = new LogoutCommand();
        }
    },
    REGISTRATE{
        {
            this.command = new RegistrateCommand();
        }
    },
    CHOOSETEST{
        {
            this.command = new ChooseTestCommand();
        }
    },
    CHECKTEST{
            {
                this.command = new CheckTestCommand();
            }
    },
    TOTESTS{
        {
            this.command=new ShowTestsCommand();
        }
    },
    TOUSERSUCCESS{
        {
            this.command= new ShowSuccessCommand();
        }
    },
    TOTABLE{
        {
            this.command= new ShowTableCommand();
        }
    },
    ADDTEST{
        {
            this.command= new AddTestCommand();
        }
    };
    IActionCommand command;
    public IActionCommand getCurrentCommand(){
        return command;
    }
}
