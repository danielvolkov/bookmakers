package controller.commands.holder;

import controller.commands.Command;

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

    public  Command getPostCommand(String url) {
        return  postCommands.get(url);
    }
    public  Command getGetCommand(String url) {
        return  getCommands.get(url);
    }


    public Map<String, Command> getGetCommand() {
        return getCommands;
    }

    public void setGetCommands(Map<String, Command> getCommands) {
        this.getCommands = getCommands;
    }
    public void setPostCommands(Map<String, Command> postCommands) {
        this.postCommands = postCommands;
    }
}
