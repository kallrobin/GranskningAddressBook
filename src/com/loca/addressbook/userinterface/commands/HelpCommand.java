package com.loca.addressbook.userinterface.commands;

import com.loca.addressbook.exceptions.InvalidCommandParameterException;

import java.util.List;

public class HelpCommand implements Command {
    private CommandType commandType = CommandType.HELP;
    private List<String> parameters;

    public HelpCommand (List<String> parameters) {
        this.parameters = parameters;
    }

    @Override
    public String getName() {
        return commandType.getCommandName();
    }

    @Override
    public String getDescription() {
        return commandType.getDescription();
    }

    @Override
    public void execute() throws InvalidCommandParameterException {
        if (parameters.size() != commandType.getArgumentCount()) {
            throw new InvalidCommandParameterException();
        }

    }

}
