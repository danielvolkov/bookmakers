package controller.commands.init;

import controller.commands.Command;

import java.util.Map;

/**
 * Created by daniel on 1/19/17.
 */
public interface InitCommands {
    Map<String,Command> initGetCommands();
    Map<String,Command> initPostCommands();
}
