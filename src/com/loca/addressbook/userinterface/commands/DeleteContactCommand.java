package com.loca.addressbook.userinterface.commands;

import com.loca.addressbook.registry.Registry;
import com.loca.addressbook.exceptions.InvalidCommandParameterException;

import java.util.List;

public class DeleteContactCommand implements Command {

    private CommandType commandType = CommandType.DELETE;
    private Registry registry;
    private List<String> parameters;

    public DeleteContactCommand (Registry registry, List<String> parameters) {
        this.registry = registry;
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
        deleteContactFromRegistry();
    }

    private void deleteContactFromRegistry() {
        String uuid = parameters.get(0);
        registry.deleteContact(uuid);
    }
}
