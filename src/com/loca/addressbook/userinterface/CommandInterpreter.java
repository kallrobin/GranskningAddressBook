package com.loca.addressbook.userinterface;

import com.loca.addressbook.userinterface.commands.*;
import com.loca.addressbook.userinterface.exceptions.InvalidCommandException;

public class CommandInterpreter {
	
	public Command interpret(CommandLine commandLine) throws InvalidCommandException {
        CommandType commandType = findCommandType(commandLine.getCommand());
        Command command = createCommand(commandType);
        return command;
	}

    private CommandType findCommandType(String command) throws InvalidCommandException {
	    CommandType inputCommandType = null;
	    for (CommandType commandType: CommandType.values()) {
	        if (commandType.toString().equals(command)) {
	            inputCommandType = commandType;
	            break;
            }
        }
        if (inputCommandType == null) {
            throw new InvalidCommandException();
        }
        return inputCommandType;
    }

    private Command createCommand(CommandType commandType) {
	    Command command = null;
	    switch (commandType) {
            case ADD:
                command = new AddContactCommand();
                break;
            case LIST:
                command = new ListCommand();
                break;
            case DELETE:
                command = new DeleteContactCommand();
                break;
            case HELP:
                command = new HelpCommand();
                break;
            case SEARCH:
                command = new SearchCommand();
                break;
            case QUIT:
                command = new QuitCommand();
                break;
        }

        return command;
    }


}
