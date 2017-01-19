package controller.commands.init;

import controller.commands.Command;
import controller.commands.holder.CommandHolder;

import java.util.Map;

/**
 * Created by daniel on 1/19/17.
 */
public class CommandHolderInit {


    public static CommandHolder init(){
        Map<String,Command> getCommands = new GeneralCommands().initGetCommands();

        Map<String,Command> postCommands = new GeneralCommands().initPostCommands();

        CommandHolder commandHolder = new CommandHolder(postCommands, getCommands);

        return commandHolder;
    }
}
