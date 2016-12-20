package com.loca.addressbook.userinterface;

import com.loca.addressbook.userinterface.commands.Command;
import com.loca.addressbook.userinterface.exceptions.InvalidCommandException;
import com.loca.addressbook.userinterface.exceptions.InvalidCommandParameterException;

public class CommandLineInterface implements InputHandler {
	
	private Console console = new Console();
	private CommandInterpreter commandInterpreter = new CommandInterpreter();

	public CommandLineInterface() {
	    console.registerInputHandler(this);
	    console.readUserInput();
    }

    @Override
    public void handle(CommandLine commandLine) {
        try {
            Command command = commandInterpreter.interpret(commandLine);
            command.execute();
        } catch (InvalidCommandException | InvalidCommandParameterException e) {
            e.printStackTrace();
        }

    }
    
}
