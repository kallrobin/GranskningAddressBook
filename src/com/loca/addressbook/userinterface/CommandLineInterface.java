package com.loca.addressbook.userinterface;

import com.loca.addressbook.registry.Registry;
import com.loca.addressbook.userinterface.commands.Command;
import com.loca.addressbook.exceptions.InvalidCommandException;
import com.loca.addressbook.exceptions.InvalidCommandParameterException;

public class CommandLineInterface implements InputHandler {
	
	private Console console = new Console();
	private CommandInterpreter commandInterpreter;

	public CommandLineInterface(Registry registry) {
	    commandInterpreter = new CommandInterpreter(console, registry);
	    console.registerInputHandler(this);
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
