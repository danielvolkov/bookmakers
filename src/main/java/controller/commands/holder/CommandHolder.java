package controller.commands.holder;

import controller.commands.Command;
import util.UrlHolder;

import java.util.Map;

/**
 * Created by daniel on 1/19/17.
 */
public class CommandHolder {
    Map<String,Command> postCommands;
    Map<String,Command> getCommands;


    public CommandHolder(Map<String, Command> postCommands, Map<String, Command> getCommands) {
        this.postCommands = postCommands;
        this.getCommands = getCommands;
    }

    private   Command getPostCommand(String url) {
        return  postCommands.get(url);
    }
    private   Command getGetCommand(String url) {
        return  getCommands.get(url);
    }


    public Command getCommand(String method, String url)  {
        Command command;
        if(method.equals(UrlHolder.POST_METHOD)){
             command = getPostCommand(url);
        }
        else {
             command = getGetCommand(url);
        }
        return command;
    }
}
