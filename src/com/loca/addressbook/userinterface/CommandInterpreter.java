package com.loca.addressbook.userinterface;

import com.loca.addressbook.registry.Registry;
import com.loca.addressbook.userinterface.commands.*;
import com.loca.addressbook.exceptions.InvalidCommandException;

import java.util.List;

public class CommandInterpreter {

    private Registry registry;
    private ConsolePrinter consolePrinter;

    public CommandInterpreter(ConsolePrinter consolePrinter, Registry registry) {
        this.registry = registry;
        this.consolePrinter = consolePrinter;
    }

    public Command interpret(CommandLine commandLine) throws InvalidCommandException {
        CommandType commandType = findCommandType(commandLine.getCommand());
        Command command = createCommand(commandType, commandLine.getParameters());
        return command;
	}

    private CommandType findCommandType(String command) throws InvalidCommandException {
	    CommandType inputCommandType = null;
	    for (CommandType commandType: CommandType.values()) {
	        if (commandType.getCommandName().equals(command)) {
	            inputCommandType = commandType;
	            break;
            }
        }
        if (inputCommandType == null) {
            throw new InvalidCommandException(command);
        }
        return inputCommandType;
    }

    private Command createCommand(CommandType commandType, List<String> parameters) {
	    Command command = null;
	    switch (commandType) {
            case ADD:
                command = new AddContactCommand(consolePrinter, registry, parameters);
                break;
            case LIST:
                command = new ListCommand(consolePrinter, registry, parameters);
                break;
            case DELETE:
                command = new DeleteContactCommand(consolePrinter, registry, parameters);
                break;
            case HELP:
                command = new HelpCommand(consolePrinter, parameters);
                break;
            case SEARCH:
                command = new SearchCommand(consolePrinter, registry, parameters);
                break;
            case QUIT:
                command = new QuitCommand(consolePrinter, parameters);
                break;
        }

        return command;
    }


}
