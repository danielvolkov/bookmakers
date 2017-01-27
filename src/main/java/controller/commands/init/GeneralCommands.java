package controller.commands.init;

import controller.commands.Command;
import controller.commands.authorization.*;


import controller.commands.user.*;
import util.UriHolder;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by daniel on 1/19/17.
 */
public class GeneralCommands implements InitCommands {
    @Override
    public Map<String, Command> initGetCommands() {
        Map<String, Command> getCommands = new HashMap<>();

        getCommands.put(UriHolder.INDEX, new IndexCommand());
        getCommands.put(UriHolder.LOGIN, new OpenLoginCommand());
        getCommands.put(UriHolder.LOGOUT, new LogOutCommand());
        getCommands.put(UriHolder.SIGNUP, new OpenSignupCommand());

        getCommands.put(UriHolder.CABINET, new OpenCabinetCommand());
        getCommands.put(UriHolder.HISTORY, new OpenHistoryCommand());
        getCommands.put(UriHolder.RIDES, new OpenRidesCommand());


        return getCommands;
    }

    @Override
    public Map<String, Command> initPostCommands() {
        Map<String, Command> postCommands = new HashMap<>();

        postCommands.put(UriHolder.SIGNUP, new SignUpCommand());
        postCommands.put(UriHolder.LOGIN, new LoginCommand());
        postCommands.put(UriHolder.DEPOSITE, new DepositeCommand());
        postCommands.put(UriHolder.WITHDRAW, new WithdrawCommand());
        postCommands.put(UriHolder.ADD_RIDE, new AddRideCommand());
        postCommands.put(UriHolder.MAKE_BET, new MakeBetCommand());
        postCommands.put(UriHolder.BET, new OpenBetCommand());
        postCommands.put(UriHolder.END_RIDE, new ConfirmRideResultsCommand());

        return postCommands;
    }


}
