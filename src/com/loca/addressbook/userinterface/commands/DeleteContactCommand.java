package com.loca.addressbook.userinterface.commands;

import com.loca.addressbook.registry.Registry;
import com.loca.addressbook.userinterface.ConsolePrinter;
import com.loca.addressbook.exceptions.InvalidCommandParameterException;
import com.loca.addressbook.exceptions.InvalidContactId;

import java.util.List;

public class DeleteContactCommand implements Command {

    private CommandType commandType = CommandType.DELETE;
    private ConsolePrinter consolePrinter;
    private Registry registry;
    private List<String> parameters;

    public DeleteContactCommand (ConsolePrinter consolePrinter, Registry registry, List<String> parameters) {
    	this.consolePrinter = consolePrinter;
        this.registry = registry;
        this.parameters = parameters;
    }

    @Override
    public void execute() throws InvalidCommandParameterException {
        validate();
        deleteContactFromRegistry();
    }

    private void deleteContactFromRegistry() {
        String uuid = parameters.get(0);
        registry.deleteContact(uuid);
    }

    private void validate() throws InvalidCommandParameterException {
        if (parameters.size() != 1) {
            throw new InvalidCommandParameterException(parameters.size(), 1);
        }
    }
}
