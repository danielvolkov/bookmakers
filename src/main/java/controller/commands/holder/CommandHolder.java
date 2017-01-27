package controller.commands.holder;

import controller.commands.Command;
import exceptions.CommandNotFoundException;
import util.UriHolder;

import java.util.Map;

/**
 * Created by daniel on 1/19/17.
 */
public class CommandHolder {
    Map<String,Command> postCommands;
    Map<String,Command> getCommands;
    Command pageNotFoundCommand;

    public CommandHolder(Map<String, Command> postCommands, Map<String, Command> getCommands, Command pageNotFoundCommand) {
        this.postCommands = postCommands;
        this.getCommands = getCommands;
        this.pageNotFoundCommand = pageNotFoundCommand;

    }

    private Command getPostCommand(String url) {
        return  postCommands.get(url);
    }
    private Command getGetCommand(String url) {
        return  getCommands.get(url);
    }

    public Command getCommand(String method, String url) throws CommandNotFoundException {
        Command command;
        if(method.equals(UriHolder.POST_METHOD)){
             command = getPostCommand(url);
        }
        else {
             command = getGetCommand(url);
        }

        if(command != null) {
            return command;
        }else {
            throw new CommandNotFoundException();
        }
    }

    public Command getPageNotFoundCommand(){
        return pageNotFoundCommand;
    }
}
