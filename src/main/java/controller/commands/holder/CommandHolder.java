package controller.commands.holder;

import controller.commands.Command;
import exceptions.CommandNotFoundException;
import util.UrlHolder;

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
        Command command = null;
        if(method.equals(UrlHolder.POST_METHOD)){
             command = getPostCommand(url);
        }
        else if (method.equals(UrlHolder.GET_METHOD)){
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
