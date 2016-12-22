package com.loca.addressbook.userinterface;

import com.loca.addressbook.Application;
import com.loca.addressbook.registry.Registry;
import com.loca.addressbook.remoteregistry.RemoteRegistry;
import com.loca.addressbook.userinterface.commands.Command;
import com.loca.addressbook.exceptions.InvalidCommandException;
import com.loca.addressbook.exceptions.InvalidCommandParameterException;

public class CommandLineInterface implements InputHandler {

    private static final String WELCOME_MESSAGE = "Welcome to AddressBook 2.0!";
	private Console console;
	private CommandInterpreter commandInterpreter;

	public CommandLineInterface(Registry registry, RemoteRegistry remoteRegistry, Console console, Application application) {
	    this.console = console;
	    commandInterpreter = new CommandInterpreter(console, registry, remoteRegistry, application);
	    console.print(WELCOME_MESSAGE);
	    console.registerInputHandler(this);

    }

    @Override
    public void handle(CommandLine commandLine) {
        try {
            Command command = commandInterpreter.interpret(commandLine);
            command.execute();
        } catch (InvalidCommandException | InvalidCommandParameterException e) {
            console.print(e.getMessage());
        }

    }
    
}
