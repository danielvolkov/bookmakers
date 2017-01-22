package controller.commands.init;

import controller.commands.Command;
import controller.commands.authorization.*;


import controller.commands.user.OpenCabinetCommand;
import controller.commands.user.OpenHistoryCommand;
import controller.commands.user.OpenRidesCommand;
import util.UrlHolder;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by daniel on 1/19/17.
 */
public class GeneralCommands implements InitCommands {
    @Override
    public Map<String, Command> initGetCommands() {
        Map<String, Command> getCommands = new HashMap<>();

        getCommands.put(UrlHolder.INDEX, new IndexCommand());
        getCommands.put(UrlHolder.LOGIN, new OpenLoginCommand());
        getCommands.put(UrlHolder.LOGOUT, new LogOutCommand());
        getCommands.put(UrlHolder.SIGNUP, new OpenSignupCommand());

        getCommands.put(UrlHolder.CABINET, new OpenCabinetCommand());
        getCommands.put(UrlHolder.HISTORY, new OpenHistoryCommand());
        getCommands.put(UrlHolder.RIDES, new OpenRidesCommand());

        return getCommands;
    }

    @Override
    public Map<String, Command> initPostCommands() {
        Map<String, Command> postCommands = new HashMap<>();

        postCommands.put(UrlHolder.SIGNUP, new SignUpCommand());
        postCommands.put(UrlHolder.LOGIN, new LoginCommand());

        return postCommands;
    }


}
