package controller.commands.init;

import controller.commands.Command;
import controller.commands.authorization.LoginCommand;


import controller.commands.authorization.SignUpCommand;
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
        getCommands.put(UrlHolder.LOGIN, new LoginCommand());
        return getCommands;
    }

    @Override
    public Map<String, Command> initPostCommands() {
        Map<String, Command> postCommands = new HashMap<>();
        postCommands.put(UrlHolder.SIGNUP, new SignUpCommand());
        return postCommands;
    }
}
